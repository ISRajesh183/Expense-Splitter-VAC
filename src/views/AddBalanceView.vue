<template>
  <div class="add-balance-page">
    <h2>Add Balance</h2>

    <div v-if="balance !== null" class="balance-box">
      <p><strong>Current Balance:</strong> ₹{{ balance.toFixed(2) }}</p>
    </div>

    <div class="form">
      <input
        v-model.number="amountToAdd"
        type="number"
        placeholder="Enter amount to add"
      />
      <button @click="addBalance">Add Amount</button>
    </div>

    <p v-if="message" class="msg">{{ message }}</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import api from "@/api/axios";

const route = useRoute();
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

    await fetchBalance();
  } catch (err) {
    message.value = "Error adding balance: " + err.message;
  }
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
.balance-box {
  margin-bottom: 20px;
  background: #eef6ff;
  padding: 10px;
  border-radius: 8px;
}
input {
  padding: 8px;
  width: 70%;
  margin-right: 10px;
  border-radius: 6px;
  border: 1px solid #ccc;
}
button {
  padding: 8px 14px;
  background: #007bff;
  border: none;
  color: white;
  border-radius: 6px;
  cursor: pointer;
}
button:hover {
  background: #0056b3;
}
.msg {
  margin-top: 15px;
  font-weight: 500;
}
</style>
