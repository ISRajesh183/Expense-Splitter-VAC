<template>
  <div class="p-6 max-w-3xl mx-auto bg-white shadow rounded-2xl mt-10">
    <h2 class="text-2xl font-bold mb-6 text-center">Create New Expense</h2>

    <form @submit.prevent="createExpense">
      <div class="mb-4">
        <label class="block text-gray-700 mb-1">Title</label>
        <input v-model="title" type="text" class="w-full border p-2 rounded" required />
      </div>

      <div class="mb-4">
        <label class="block text-gray-700 mb-1">Amount</label>
        <input v-model.number="amount" type="number" class="w-full border p-2 rounded" required min="1" />
      </div>

      <div class="mb-4">
        <label class="block text-gray-700 mb-1">Select Participants</label>
        <div class="grid grid-cols-2 gap-2">
          <div v-for="person in persons" :key="person.id" class="flex items-center space-x-2">
            <input type="checkbox" :id="person.id" v-model="selectedPeople" :value="person.id" />
            <label :for="person.id">{{ person.name }}</label>
          </div>
        </div>
      </div>

      <div v-if="selectedPeople.length" class="mb-4 border-t pt-4">
        <h3 class="font-semibold mb-2">Split Amounts</h3>
        <div v-for="id in selectedPeople" :key="id" class="flex justify-between items-center mb-2">
          <span>{{ personName(id) }}</span>
          <input
            v-model.number="splits[id]"
            type="number"
            class="border p-1 w-24 rounded"
            :placeholder="equalShare"
          />
        </div>
      </div>

      <div class="mb-4">
        <label class="block text-gray-700 mb-1">Description</label>
        <textarea v-model="description" class="w-full border p-2 rounded"></textarea>
      </div>

      <button type="submit" class="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700">
        Create Expense
      </button>

      <p v-if="message" class="text-green-600 text-center mt-4">{{ message }}</p>
      <p v-if="error" class="text-red-600 text-center mt-4">{{ error }}</p>
    </form>

    <div class="mt-6 flex justify-center gap-4">
      <button 
        type="button" 
        class="px-4 py-2 border rounded-md font-semibold text-blue-600 border-blue-500 hover:bg-blue-50" 
        @click="goToBalancePage"
      >
         View My Balance
      </button>
      
      <button 
        type="button" 
        class="px-4 py-2 border rounded-md font-semibold text-blue-600 border-blue-500 hover:bg-blue-50" 
        @click="goToHome"
      >
         Go to Home
      </button>
    </div>

  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import api from '@/api/axios';
import { useRouter } from 'vue-router';
import { useAuthStore } from '@/stores/auth.js';

const auth = useAuthStore();
const router = useRouter();

const title = ref('');
const amount = ref(0);
const description = ref('');
const persons = ref([]);
const selectedPeople = ref([]);
const splits = ref({});
const message = ref('');
const error = ref('');

const equalShare = computed(() => (amount.value / (selectedPeople.value.length || 1)).toFixed(2));

const personName = (id) => {
  const p = persons.value.find((x) => x.id === id);
  return p ? p.name : '';
};

onMounted(async () => {
  try {
    const res = await api.get('/persons');
    persons.value = res.data;
  } catch (err) {
    error.value = "Failed to load participants.";
  }
});

const createExpense = async () => {
  error.value = '';
  message.value = '';
  try {
    const payload = {
      description: title.value, 
      totalAmount: amount.value,
      paidBy: auth.user?.id,
      participants: selectedPeople.value.map((id) => ({
        personId: id,
        shareAmount: parseFloat(splits.value[id] || equalShare.value),
      })),
      category: 'General', 
      expenseDate: new Date().toISOString(),
    };

    console.log('📤 Sending payload:', payload);

    await api.post('/expenses', payload);
    message.value = '✅ Expense created successfully!';

    // reset form
    title.value = '';
    description.value = '';
    amount.value = 0;
    selectedPeople.value = [];
    splits.value = {};
  } catch (err) {
    console.error('❌ Expense creation failed:', err.response?.data || err);
    error.value = err.response?.data?.message || 'Failed to create expense';
  }
};

// Navigate to the logged-in user’s balance page
const goToBalancePage = () => {
  if (auth.user && auth.user.id) {
    router.push(`/balance/${auth.user.id}`);
  } else {
    error.value = 'User not found. Please log in again.';
  }
};

// Navigate to the home page
const goToHome = () => {
  router.push('/home');
};

</script>