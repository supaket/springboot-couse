package com.example.demo.greeting.controller;

import com.example.demo.greeting.service.WinnerPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
public class GreetingControllerSliceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    WinnerPrice service;

    @Test
    public void shouldReturnGreetingBackWhenCallHello() throws Exception {

        String result = this.mvc.perform(get("/hello/user1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();

    }
}
