package com.example.testdouble;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestDoubleShowcase {

    @Mock
    Random random;

    @Test
    public void shouldReturn5ForRandom(){
        //Arrange
        //Stub
        when(random.nextInt()).thenReturn(5);

        //Act
        int result = random.nextInt();

        //Assert
        assertEquals(result, 5);

    }

    @Test
    public void shouldCallRandomWith10(){
        //Arrange
        //Act
        Random random1 = new Random();

        Random spyRandom1 = Mockito.spy(random1);

        //Act
        spyRandom1.nextInt(10);

        //Assert
        Mockito.verify(spyRandom1, times(1)).nextInt(10);

    }

    @Test
    public void shouldCallRandomWithInteger(){
        //Arrange
        //Act
        Random random1 = new Random();

        Random spyRandom1 = Mockito.spy(random1);

        //Act
        spyRandom1.nextInt(10);

        //Assert
        //Mockito.verify(spyRandom1, ).nextInt(10);

    }

}
