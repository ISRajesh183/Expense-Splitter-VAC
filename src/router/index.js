import { createRouter, createWebHistory } from 'vue-router';
import RegisterPage from '@/views/RegisterPage.vue';
import LoginPage from '@/views/LoginPage.vue';
import CreateExpensePage from '@/views/CreateExpensePage.vue';
import BalanceView from '@/views/BalanceView.vue';
import AddBalanceView from '@/views/AddBalanceView.vue';
import { useAuthStore } from '@/stores/auth.js';

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/register', component: RegisterPage },
  { path: '/login', component: LoginPage },
  {
    path: '/create-expense',
    component: CreateExpensePage,
    meta: { requiresAuth: true },
  },
  {
    path: '/balance/:id',
    name: 'BalanceView',
    component: BalanceView,
    props: true,
    meta: { requiresAuth: true },
  },
  {
    path: '/add-balance/:id',
    name: 'AddBalanceView',
    component: AddBalanceView,
    props: true,
    meta: { requiresAuth: true },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 🔒 Auth Guard
router.beforeEach((to, from, next) => {
  const auth = useAuthStore();

  if (to.meta.requiresAuth && !auth.isAuthenticated) {
    next('/login');
  } else {
    next();
  }
});

export default router;
