package com.example.fizzbuzz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void sayFizzWhenDivideByThree(){
        // AAA pattern

        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        String result = fizzBuzz.say(3);
        //Assert
        assertEquals("Fizz", result);

        //Act
        String result2 = fizzBuzz.say(6);
        //Assert
        assertEquals("Fizz", result2);

    }

    @Test
    public void sayBuzzWhenDivideByFive(){
        // AAA pattern

        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        String result = fizzBuzz.say(5);

        //Assert
        assertEquals("Buzz", result);

        //Act
        String result2 = fizzBuzz.say(10);

        //Assert
        assertEquals("Buzz", result2);
    }

    @Test
    public void sayFizzBuzzWhenBothDivideByThreeAndFive(){
        // AAA pattern

        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        String result = fizzBuzz.say(15);

        //Assert
        assertEquals("FizzBuzz", result);
    }

}
