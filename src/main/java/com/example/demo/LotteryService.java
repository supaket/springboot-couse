package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class LotteryService {
    public void lotto() {
        System.out.println(new Random().nextInt(100));
    }
}

@Component
class MainComponent {

    public LotteryService service; //A
    public MainComponent(LotteryService service){ //B
       this.service = service; //C
    }

    public void sayHelloFunction() {
        System.out.println("Hello");
        service.lotto(); //D
    }
}
