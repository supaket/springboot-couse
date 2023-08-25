package com.example.testdouble;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
        verify(spyRandom1, times(1)).nextInt(10);

    }

    @Test
    public void shouldCallRandomWithSpecificValue(){
        //Arrange
        //Act
        Random random1 = new Random();

        Random spyRandom1 = Mockito.spy(random1);

        //Act
        spyRandom1.nextInt(10);

        //Assert

        // Capture the argument using ArgumentCaptor
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(spyRandom1).nextInt(argumentCaptor.capture());

        int capturedValue = argumentCaptor.getValue();

        // Check the captured argument
        assertEquals(10 , capturedValue);
    }

}
