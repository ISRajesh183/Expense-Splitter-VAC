package com.ssn.esa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssn.esa.dto.LoginRequest;
import com.ssn.esa.dto.RegisterRequest;
import com.ssn.esa.model.User;
import com.ssn.esa.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

/**
 * Unit test for AuthController using MockMvc
 */
@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegisterUser() throws Exception {
        RegisterRequest request = new RegisterRequest("abc@gmail.com", "abc", "ABC User");
        User user = new User("1", "abc@gmail.com", "abc", "ABC User");

        Mockito.when(authService.register(Mockito.any(RegisterRequest.class))).thenReturn(user);

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("abc@gmail.com")));
    }

    @Test
    void testLoginUser() throws Exception {
        LoginRequest request = new LoginRequest("abc@gmail.com", "abc");
        User user = new User("1", "abc@gmail.com", "abc", "ABC User");

        Mockito.when(authService.login(Mockito.any(LoginRequest.class))).thenReturn(user);

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("ABC User")));
    }
}
