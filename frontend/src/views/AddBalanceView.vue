<template>
  <div class="add-balance-page">
    <div class="page-header">
      <h2>Add Balance</h2>
      <button @click="goToHome" class="nav-btn">Go to Home</button>
    </div>

    <div v-if="balance !== null" class="balance-box">
      <p><strong>Current Balance:</strong> ₹{{ balance.toFixed(2) }}</p>
    </div>

    <div class="form">
      <input
        v-model.number="amountToAdd"
        type="number"
        placeholder="Enter amount to add"
      />
      <button @click="addBalance" class="add-btn">Add Amount</button>
    </div>

    <p v-if="message" class="msg">{{ message }}</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import api from "@/api/axios";

const route = useRoute();
const router = useRouter();
const personId = route.params.id;

const balance = ref(null);
const amountToAdd = ref("");
const message = ref("");

const fetchBalance = async () => {
  try {
    const res = await api.get(`/persons/${personId}/balance`);
    balance.value = res.data.balance;
  } catch (err) {
    message.value = "Error fetching balance: " + err.message;
  }
};

const addBalance = async () => {
  if (!amountToAdd.value || amountToAdd.value <= 0) {
    message.value = "Please enter a valid positive amount";
    return;
  }

  try {
    const res = await api.post(`/persons/${personId}/add-balance`, { amount: amountToAdd.value });
    balance.value = res.data.balance;
    message.value = "✅ Balance added successfully!";
    amountToAdd.value = "";
  } catch (err) {
    message.value = "Error adding balance: " + (err.response?.data?.message || err.message);
  }
};

const goToHome = () => {
  router.push('/home');
};

onMounted(fetchBalance);
</script>

<style scoped>
.add-balance-page {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 0 10px rgba(0,0,0,0.15);
  text-align: center;
  background: #fafafa;
}

.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
.page-header h2 {
  margin: 0;
}
.nav-btn {
  padding: 8px 14px;
  background: #007bff;
  border: none;
  color: white;
  border-radius: 6px;
  cursor: pointer;
  font-weight: 500;
}
.nav-btn:hover {
  background: #0056b3;
}

.balance-box {
  margin-bottom: 20px;
  background: #eef6ff;
  padding: 10px;
  border-radius: 8px;
}

/* --- UPDATED STYLES --- */
.form {
  margin-bottom: 15px;
  display: flex; /* Use flexbox */
  flex-direction: column; /* Stack items vertically */
  align-items: center; /* Center them */
  gap: 12px; /* This adds 12px of space between the input and button */
}

input {
  padding: 10px; /* Made it a bit taller */
  width: 90%; /* Make input wide */
  border-radius: 6px;
  border: 1px solid #ccc;
  box-sizing: border-box; /* Important for width calculation */
}

.add-btn {
  padding: 10px 14px; /* Made it a bit taller */
  background: #007bff;
  border: none;
  color: white;
  border-radius: 6px;
  cursor: pointer;
  width: 90%; /* Make button wide */
  box-sizing: border-box; /* Important for width calculation */
}
/* --- END OF UPDATED STYLES --- */

.add-btn:hover {
  background: #0056b3;
}

.msg {
  margin-top: 15px;
  font-weight: 500;
}
</style>