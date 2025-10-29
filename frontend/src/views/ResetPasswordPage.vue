<template>
  <div class="p-6 max-w-md mx-auto bg-white shadow rounded-2xl mt-20">
    <h2 class="text-2xl font-bold mb-6 text-center">Reset Password</h2>

    <form @submit.prevent="handleReset">
      <div class="mb-4">
        <label class="block text-gray-700 mb-1">Your Email</label>
        <input 
          v-model="email" 
          type="email" 
          class="w-full border p-2 rounded" 
          required 
          placeholder="user@example.com"
        />
      </div>

      <div class="mb-6">
        <label class="block text-gray-700 mb-1">New Password</label>
        <input 
          v-model="newPassword" 
          type="password" 
          class="w-full border p-2 rounded" 
          required 
          placeholder="New password"
        />
      </div>

      <button 
        type="submit" 
        class="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700 disabled:bg-gray-400"
        :disabled="loading"
      >
        {{ loading ? 'Processing...' : 'Set New Password' }}
      </button>

      <p v-if="message" class="text-green-600 text-center mt-4">{{ message }}</p>
      <p v-if="error" class="text-red-600 text-center mt-4">{{ error }}</p>
    </form>
    
    <div class="text-center mt-4">
      <router-link to="/login" class="text-blue-600 hover:underline">
        Back to Login
      </router-link>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import api from '@/api/axios'
import { useRouter } from 'vue-router'

const router = useRouter();
const email = ref('');
const newPassword = ref('');
const message = ref('');
const error = ref('');
const loading = ref(false);

const handleReset = async () => {
  loading.value = true;
  message.value = '';
  error.value = '';

  try {
    const payload = {
      email: email.value,
      newPassword: newPassword.value,
    };
    
    // Call the new backend endpoint
    await api.post('/auth/reset-password', payload);
    
    message.value = '✅ Password reset! Redirecting to login...';
    
    // Clear form
    email.value = '';
    newPassword.value = '';
    
    // Redirect to login after a short delay
    setTimeout(() => {
      router.push('/login');
    }, 2000);

  } catch (err) {
    console.error('❌ Password reset failed:', err.response?.data || err);
    error.value = err.response?.data?.message || 'Failed to reset password. Please check the email.';
  } finally {
    loading.value = false;
  }
};
</script>