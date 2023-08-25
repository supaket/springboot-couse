package com.example.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    //Arrange
    FizzBuzz fizzBuzz;
    Random random = new Random();

    @BeforeEach
    public void setup(){
        fizzBuzz  = new FizzBuzz();
    }

    @Test
    public void sayFizzWhenDivideByThree(){
        // AAA pattern
        // Multiply by 3 to ensure divisibility
        int divisibleByThree = 3 * (random.nextInt(10) +1) ;

        //Act
        String result = fizzBuzz.say(divisibleByThree);
        //Assert
        assertEquals("Fizz", result);
    }

    @Test
    public void sayBuzzWhenDivideByFive(){
        // AAA pattern
        // Multiply by 3,5 to ensure divisibility
        int divisibleByFive = 5 * (random.nextInt(10) +1) ;

        //Act
        String result = fizzBuzz.say(divisibleByFive);

        //Assert
        assertEquals("Buzz", result);
    }

    @Test
    public void sayFizzBuzzWhenBothDivideByThreeAndFive(){
        // AAA pattern
        // Multiply by 3 to ensure divisibility
        int divisibleByThreeAndFive = 3 * 5 * (random.nextInt(10) + 1);

        //Act
        String result = fizzBuzz.say(divisibleByThreeAndFive);

        //Assert
        assertEquals("FizzBuzz", result);
    }

}
