import { defineStore } from 'pinia'
import api from '@/api/axios'

export const useExpenseStore = defineStore('expense', {
  state: () => ({
    expenses: [],
    loading: false,
    error: null,
  }),

  actions: {
    async fetchExpenses(personId, status = 'ALL') {
      // ... (your existing fetchExpenses action)
      if (!personId) {
        this.error = 'No user ID provided.'
        return
      }
      
      this.loading = true
      this.error = null
      
      try {
        let endpoint = ''
        switch (status.toUpperCase()) {
          case 'DUE':
            endpoint = `/expenses/person/${personId}/due`
            break
          case 'PAID':
            endpoint = `/expenses/person/${personId}/paid`
            break
          case 'ALL':
          default:
            endpoint = `/expenses/person/${personId}/all`
            break
        }
        
        const res = await api.get(endpoint)
        this.expenses = res.data
        
      } catch (err) {
        this.error = 'Error fetching expenses: ' + (err.response?.data?.message || err.message)
      } finally {
        this.loading = false
      }
    },

    // --- ADD THIS NEW ACTION ---
    async payExpense(personId, expenseId, currentFilter) {
      this.error = null // Clear old errors

      try {
        // Call the backend endpoint that already exists
        await api.post(`/expenses/${expenseId}/pay/${personId}`);

        // Success! Now, refresh the list to show the change.
        // (This will make the item move from 'Due' to 'Paid')
        await this.fetchExpenses(personId, currentFilter);

      } catch (err) {
        // This will catch the "InsufficientBalanceException" from your backend!
        this.error = 'Payment failed: ' + (err.response?.data?.message || err.message);
      }
    }
  },
})