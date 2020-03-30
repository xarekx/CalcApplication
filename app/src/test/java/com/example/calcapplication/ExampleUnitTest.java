package com.example.calcapplication;

import com.example.calcapplication.QuadraticFunction.CalcQuadraticFunction;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void calcTopP_correct() {
        CalcQuadraticFunction calcQuadraticFunction = new CalcQuadraticFunction(2,4,4);




    }

}