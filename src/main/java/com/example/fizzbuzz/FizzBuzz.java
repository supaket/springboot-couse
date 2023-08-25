package com.example.fizzbuzz;

public class FizzBuzz {
    public String say(int i) {
        if(i==3){
            return "Fizz";
        }else if(i==5) {
            return "Buzz";
        }

        return Integer.valueOf(i).toString();
    }
}
