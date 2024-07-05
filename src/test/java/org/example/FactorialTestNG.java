package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FactorialTestNG {

    @Test
    public void testFactorialInteger() {
        assertEquals(Factorial.calculateFactorial(5), 120.0);
    }

    @Test
    public void testFactorialFractional() {
        assertEquals(Factorial.calculateFactorial(3.5), 11.631728, 0.0001);
    }

    @Test
    public void testFactorialZero() {
        assertEquals(Factorial.calculateFactorial(0), 1.0);
    }

    @Test
    public void testFactorialNegativeInteger() {
        try {
            Factorial.calculateFactorial(-1);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Factorial is not defined for negative integers.");
        }
    }

    @Test
    public void testFactorialNegativeFractional() {
        assertEquals(Factorial.calculateFactorial(-0.5), 1.772453850905516, 0.0001);
    }

    @Test
    public void testFactorialPositiveInteger() {
        assertEquals(Factorial.calculateFactorial(6), 720.0);
    }
}
