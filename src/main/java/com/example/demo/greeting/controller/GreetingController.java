package com.example.demo.greeting.controller;

import com.example.demo.greeting.service.LotteryService;
import com.example.demo.greeting.service.WinnerPrice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class GreetingController {
    WinnerPrice service;
    public GreetingController(WinnerPrice service) {
        this.service = service;
    }

    @GetMapping("/hello/{name}")
    public String greeting(@PathVariable("name") String name){
        return "Hello "+ name +" "+ service.yourWinnerPrice();
    }
}
