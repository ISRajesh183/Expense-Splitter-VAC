<template>
  <div>
    <nav class="bg-blue-600 text-white p-4 flex justify-between items-center shadow">
      <h1 class="font-bold text-xl">💸 Expense Splitter</h1>

      <div>
        <router-link
          to="/create-expense"
          class="mx-2 hover:underline"
          v-if="auth.isAuthenticated"
        >
          Create Expense
        </router-link>

        <button
          v-if="auth.isAuthenticated"
          @click="logout"
          class="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded"
        >
          Logout
        </button>

        <router-link
          v-else
          to="/login"
          class="bg-white text-blue-600 px-3 py-1 rounded hover:bg-blue-50"
        >
          Login
        </router-link>
      </div>
    </nav>

    <router-view />
  </div>
</template>

<script setup>
import { useAuthStore } from '@/stores/auth.js';
import { useRouter } from 'vue-router';

const auth = useAuthStore();
const router = useRouter();

const logout = () => {
  auth.logout();
  router.push('/login');
};
</script>
