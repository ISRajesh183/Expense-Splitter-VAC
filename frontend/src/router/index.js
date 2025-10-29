import { createRouter, createWebHistory } from 'vue-router';
import RegisterPage from '@/views/RegisterPage.vue';
import LoginPage from '@/views/LoginPage.vue';
import CreateExpensePage from '@/views/CreateExpensePage.vue';
import BalanceView from '@/views/BalanceView.vue';
import AddBalanceView from '@/views/AddBalanceView.vue';
import { useAuthStore } from '@/stores/auth.js';
import ResetPasswordPage from '@/views/ResetPasswordPage.vue';

// --- ADD THIS LINE ---
import HomePage from '@/views/HomePage.vue'; // 1. Import the new page

const routes = [
  // --- MODIFY THIS LINE ---
  { path: '/', redirect: '/home' }, // 2. Change redirect to '/home'
  
  // --- ADD THIS NEW ROUTE OBJECT ---
  { 
    path: '/home', 
    name: 'HomePage',
    component: HomePage, 
    meta: { requiresAuth: true } 
  }, // 3. Add the home page route
  
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
  { path: '/reset-password', component: ResetPasswordPage }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 🔒 Auth Guard
router.beforeEach((to, from, next) => {
  const auth = useAuthStore();

  // --- ADD THIS LOGIC ---
  // Redirect logged-in users away from login/register
  if ((to.path === '/login' || to.path === '/register') && auth.isAuthenticated) {
    next('/home');
    return; // Stop execution
  }
  // --- END OF ADDED LOGIC ---

  if (to.meta.requiresAuth && !auth.isAuthenticated) {
    next('/login');
  } else {
    next();
  }
});

export default router;