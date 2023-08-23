package com.example.demo;

import org.springframework.stereotype.Component;

public class LotteryService {
    public void sayHi() {
        System.out.println("Called sayHi");
    }
}

@Component
class MainComponent {
    public void sayHelloFunction() {
        System.out.println("Hello");
    }
}
