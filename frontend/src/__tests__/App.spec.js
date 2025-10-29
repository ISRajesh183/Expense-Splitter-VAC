import { describe, it, expect, vi } from 'vitest'
import { mount } from '@vue/test-utils'
import { createTestingPinia } from '@pinia/testing'
import App from '@/App.vue'

describe('App', () => {
  it('mounts and renders properly', () => {
    const wrapper = mount(App, {
      global: {
        plugins: [createTestingPinia({ createSpy: vi.fn })], // ✅ add this
        stubs: ['router-link', 'router-view'], // prevents router warnings
      },
    })
    expect(wrapper.exists()).toBe(true)
  })
})
