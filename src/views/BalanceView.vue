<template>
  <div class="balance-page">
    <h2>View Balance</h2>

    <div v-if="balance !== null" class="balance-box">
      <p><strong>Current Balance:</strong> ₹{{ balance.toFixed(2) }}</p>
    </div>

    <p v-if="message" class="msg">{{ message }}</p>

    <button class="nav-btn" @click="goToAddBalance">
      ➕ Add Balance To Account
    </button>
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
const message = ref("");

const fetchBalance = async () => {
  try {
    const res = await api.get(`/persons/${personId}/balance`);
    balance.value = res.data.balance;
  } catch (err) {
    message.value = "Error fetching balance: " + err.message;
  }
};

const goToAddBalance = () => {
  router.push(`/add-balance/${personId}`);
};

onMounted(fetchBalance);
</script>

<style scoped>
.balance-page {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 0 10px rgba(0,0,0,0.15);
  text-align: center;
  background: #fafafa;
}
.balance-box {
  margin-bottom: 20px;
  background: #eef6ff;
  padding: 10px;
  border-radius: 8px;
}
.nav-btn {
  padding: 8px 14px;
  background: #007bff;
  border: none;
  color: white;
  border-radius: 6px;
  cursor: pointer;
}
.nav-btn:hover {
  background: #0056b3;
}
.msg {
  margin-top: 15px;
  font-weight: 500;
}
</style>
