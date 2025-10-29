<template>
  <div class="home-page">
    <div class="page-header">
      <h2>My Expenses</h2>
      <button @click="goToAddBalance" class="nav-btn">
        Add Balance
      </button>
    </div>

    <div class="filter-buttons">
      <button @click="getExpenses('ALL')" :class="{ active: currentFilter === 'ALL' }">
        All
      </button>
      <button @click="getExpenses('DUE')" :class="{ active: currentFilter === 'DUE' }">
        Due
      </button>
      <button @click="getExpenses('PAID')" :class="{ active: currentFilter === 'PAID' }">
        Paid
      </button>
    </div>

    <div v-if="paymentError" class="error payment-error">{{ paymentError }}</div>

    <div v-if="expenseStore.loading" class="loading">Loading...</div>

    <div v-if="expenseStore.error && !paymentError" class="error">{{ expenseStore.error }}</div>

    <div v-if="!expenseStore.loading && !expenseStore.error" class="expense-list">
      <div v-if="expenseStore.expenses.length === 0" class="empty-state">
        No expenses found.
      </div>
      
      <div v-for="expense in expenseStore.expenses" :key="expense.id" class="expense-card">
        <div class="card-header">
          <h3>{{ expense.description }}</h3>
          <span class="total-amount">₹{{ expense.totalAmount.toFixed(2) }}</span>
        </div>
        <div class="card-body">
          <p>Paid by: <strong>{{ expense.paidByName }}</strong></p>
          <p>Category: <strong>{{ expense.category || 'N/A' }}</strong></p>
          <p>Date: <strong>{{ new Date(expense.expenseDate).toLocaleString() }}</strong></p>
          
          <div v-if="getUserShare(expense)" class="my-share">
            <p>Your Share: <strong>₹{{ getUserShare(expense).shareAmount.toFixed(2) }}</strong></p>
            <span :class="['status-badge', getUserShare(expense).isPaid ? 'paid' : 'due']">
              {{ getUserShare(expense).isPaid ? 'Paid' : 'Due' }}
            </span>
          </div>

          <div v-if="getUserShare(expense) && !getUserShare(expense).isPaid" class="pay-section">
            <button 
              @click="handlePayment(expense.id)" 
              :disabled="paymentLoading === expense.id"
              class="pay-button"
            >
              {{ paymentLoading === expense.id ? 'Processing...' : 'Pay Now with Balance' }}
            </button>
          </div>

        </div>
      </div>
    </div>

  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useAuthStore } from '@/stores/auth'
import { useExpenseStore } from '@/stores/expenseStore'
import { useRouter } from 'vue-router' // --- NEW ---

// Get Pinia stores
const authStore = useAuthStore()
const expenseStore = useExpenseStore()
const router = useRouter() // --- NEW ---

const currentFilter = ref('ALL')
const userId = authStore.user?.id 

const paymentLoading = ref(null); 
const paymentError = ref(null);   

// Function to call the store action
const getExpenses = (status) => {
  currentFilter.value = status
  paymentError.value = null 
  expenseStore.error = null 
  expenseStore.fetchExpenses(userId, status)
}

// Helper function to find the logged-in user's participation details
const getUserShare = (expense) => {
  if (!expense.participants || !userId) return null;
  return expense.participants.find(p => p.personId === userId)
}

// Function to handle the payment click
const handlePayment = async (expenseId) => {
  paymentLoading.value = expenseId;
  paymentError.value = null;
  expenseStore.error = null; 

  await expenseStore.payExpense(userId, expenseId, currentFilter.value);

  if (expenseStore.error) {
    paymentError.value = expenseStore.error;
  }
  
  paymentLoading.value = null; 
}

// --- NEW: Function to navigate to Add Balance page ---
const goToAddBalance = () => {
  if (userId) {
    router.push(`/add-balance/${userId}`);
  }
}

// Fetch initial data ("ALL") when the component loads
onMounted(() => {
  if (userId) {
    getExpenses('ALL')
  }
})
</script>

<style scoped>
.home-page {
  max-width: 800px;
  margin: 20px auto;
  padding: 20px;
}

/* --- NEW: Styles for the header and nav button --- */
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
  background: #007bff; /* Blue */
  border: none;
  color: white;
  border-radius: 6px;
  cursor: pointer;
  font-weight: 500;
}
.nav-btn:hover {
  background: #0056b3;
}
/* --- End new styles --- */

.filter-buttons {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}
.filter-buttons button {
  padding: 8px 16px;
  border: 1px solid #ddd;
  background: #f9f9f9;
  border-radius: 6px;
  cursor: pointer;
  font-weight: 500;
}
.filter-buttons button.active {
  background: #007bff;
  color: white;
  border-color: #007bff;
}

.loading, .error, .empty-state {
  text-align: center;
  margin-top: 40px;
  font-size: 1.1em;
  color: #555;
}
.error {
  color: red;
}

.expense-list {
  display: grid;
  gap: 15px;
}

.expense-card {
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  background: #fafafa;
  box-shadow: 0 2px 4px rgba(0,0,0,0.05);
  overflow: hidden;
}
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px 20px;
  background: #f1f1f1;
}
.card-header h3 {
  margin: 0;
}
.total-amount {
  font-size: 1.2em;
  font-weight: bold;
  color: #333;
}

.card-body {
  padding: 15px 20px;
  position: relative;
}
.card-body p {
  margin: 8px 0;
}

.my-share {
  margin-top: 15px;
  padding-top: 10px;
  border-top: 1px dashed #ccc;
}
.status-badge {
  position: absolute;
  top: 15px;
  right: 15px;
  padding: 5px 10px;
  border-radius: 12px;
  font-weight: bold;
  font-size: 0.9em;
}
.status-badge.paid {
  background: #d4edda;
  color: #155724;
}
.status-badge.due {
  background: #f8d7da;
  color: #721c24;
}

.pay-section {
  margin-top: 15px;
  text-align: right;
}
.pay-button {
  padding: 8px 12px;
  background: #28a745; /* Green */
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-weight: 500;
}
.pay-button:hover {
  background: #218838;
}
.pay-button:disabled {
  background: #ccc;
  cursor: not-allowed;
}

.payment-error {
  color: #721c24; /* Red */
  background: #f8d7da;
  border: 1px solid #f5c6cb;
  padding: 10px 15px;
  border-radius: 6px;
  margin-bottom: 15px;
}
</style>