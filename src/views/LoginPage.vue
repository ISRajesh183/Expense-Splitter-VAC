<template>
  <div class="flex justify-center items-center min-h-screen bg-gray-100">
    <div class="bg-white p-8 rounded-2xl shadow-md w-full max-w-md">
      <h2 class="text-2xl font-bold text-center mb-6">Login</h2>

      <form @submit.prevent="loginUser">
        <div class="mb-4">
          <label class="block text-gray-700 mb-1">Email</label>
          <input
            v-model="email"
            type="email"
            class="w-full border p-2 rounded"
            required
          />
        </div>

        <div class="mb-4">
          <label class="block text-gray-700 mb-1">Password</label>
          <input
            v-model="password"
            type="password"
            class="w-full border p-2 rounded"
            required
          />
        </div>

        <button
          type="submit"
          class="w-full bg-green-600 text-white p-2 rounded hover:bg-green-700"
        >
          Login
        </button>

        <p v-if="error" class="text-red-500 text-center mt-3">{{ error }}</p>
      </form>

      <!-- Add this section -->
      <p class="text-center text-gray-600 mt-6">
        Don't have an account?
        <router-link
          to="/register"
          class="text-blue-600 hover:underline font-medium"
        >
          Register
        </router-link>
      </p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import api from '@/api/axios'
import { useAuthStore } from '@/stores/auth.js'
import { useRouter } from 'vue-router'

const email = ref('')
const password = ref('')
const error = ref('')
const router = useRouter()
const auth = useAuthStore()

const loginUser = async () => {
  try {
    error.value = ''
    const response = await api.post('/auth/login', {
      email: email.value,
      password: password.value,
    })

    if (response.data.success) {
      auth.setUser(response.data.user)
      router.push('/create-expense')
    } else {
      error.value = response.data.message || 'Invalid credentials'
    }
  } catch (err) {
    error.value = err.response?.data?.message || 'Invalid credentials'
  }
}
</script>
