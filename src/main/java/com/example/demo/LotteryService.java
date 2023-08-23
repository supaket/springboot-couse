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
class WinnerPrice {
    public String yourWinnerPrice() {
        return "$1,000,000";
    }
}

@Component
class MainComponent {

    public LotteryService service; //A

    public WinnerPrice price;

    public MainComponent(LotteryService service, WinnerPrice winnerPrice){ //B
       this.service = service; //C
       this.price =  winnerPrice;
    }

    public void sayHelloFunction() {
        System.out.println("Hello");
        service.lotto(); //D

        System.out.println("your winner price is " + price.yourWinnerPrice());
    }
}
