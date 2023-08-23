package com.example.demo.greeting.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class WinnerPrice {
    public String yourWinnerPrice() {
        return "$1,000,000";
    }
}
