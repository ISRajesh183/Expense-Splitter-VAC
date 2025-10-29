import { mount } from '@vue/test-utils'
import { describe, it, expect, vi } from 'vitest'
import { createRouter, createWebHistory } from 'vue-router'
import BalanceView from '@/views/BalanceView.vue'
import api from '@/api/axios'

// Mock API call
vi.mock('@/api/axios', () => ({
  default: {
    get: vi.fn(() => Promise.resolve({ data: { balance: 120.5 } })),
  },
}))

// Create a dummy router so useRoute() and useRouter() work
const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/balance/:id', component: BalanceView },
  ],
})

describe('BalanceView.vue', () => {
  it('renders balance correctly', async () => {
    router.push('/balance/1') // simulate route with param
    await router.isReady()

    const wrapper = mount(BalanceView, {
      global: {
        plugins: [router],
      },
    })

    // Wait for async fetch
    await new Promise(resolve => setTimeout(resolve, 10))

    expect(wrapper.html()).toContain('₹120.50')
  })
})
