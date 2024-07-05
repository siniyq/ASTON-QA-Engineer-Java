package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    @Test
    public void testFactorialZero() {
        assertEquals(Factorial.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOne() {
        assertEquals(Factorial.calculateFactorial(1), 1);
    }

    @Test
    public void testFactorialFive() {
        assertEquals(Factorial.calculateFactorial(5), 120);
    }

    @Test
    public void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-1);
        });
    }
}
