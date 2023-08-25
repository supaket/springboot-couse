package com.example.demo.user.controller;

import com.example.demo.user.gateway.PostGateway;
import com.example.demo.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @MockBean
    PostGateway postGateway;

    @Test
    public void shouldHttpReturn500IfServerFailed() throws Exception {
       when(userService.findById(10)).thenThrow(new RuntimeException());
        mvc.perform(get("/users/10"))
                .andExpect(status().is5xxServerError());
    }
}