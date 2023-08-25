package com.example.demo.greeting.controller;

import com.example.demo.greeting.service.WinnerPrice;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerSpringbootTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnGreetBackWhenCallHello(){
       String result = testRestTemplate.getForObject("/hello/user1",String.class);

       assertEquals(result, "Hello user1 $1,000,000");

    }

}