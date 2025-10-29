<template>
  <div class="flex justify-center items-center min-h-screen bg-gray-100">
    <div class="bg-white p-8 rounded-2xl shadow-md w-full max-w-md">
      <h2 class="text-2xl font-bold text-center mb-6">Register</h2>

      <form @submit.prevent="registerUser">
        <div class="mb-4">
          <label class="block text-gray-700 mb-1">Name</label>
          <input v-model="name" type="text" class="w-full border p-2 rounded" required />
        </div>

        <div class="mb-4">
          <label class="block text-gray-700 mb-1">Email</label>
          <input v-model="email" type="email" class="w-full border p-2 rounded" required />
        </div>

        <div class="mb-4">
          <label class="block text-gray-700 mb-1">Password</label>
          <input v-model="password" type="password" class="w-full border p-2 rounded" required />
        </div>

        <button type="submit" class="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700">
          Register
        </button>

        <p class="text-center text-sm mt-4">
          Already have an account?
          <router-link to="/login" class="text-blue-600 underline">Login</router-link>
        </p>
      </form>

      <p v-if="error" class="text-red-500 text-center mt-3">{{ error }}</p>
      <p v-if="success" class="text-green-600 text-center mt-3">Registered successfully!</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import api from '@/api/axios';

const name = ref('');
const email = ref('');
const password = ref('');
const error = ref('');
const success = ref(false);

const registerUser = async () => {
  try {
    error.value = '';
    await api.post('/auth/register', {
      name: name.value,
      email: email.value,
      password: password.value,
    });
    success.value = true;
  } catch (err) {
    error.value = err.response?.data?.message || 'Registration failed.';
  }
};
</script>
