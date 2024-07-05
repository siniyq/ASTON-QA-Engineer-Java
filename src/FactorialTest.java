import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorialZero() {
        assertEquals(1, Factorial.calculateFactorial(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(1, Factorial.calculateFactorial(1));
    }

    @Test
    public void testFactorialFive() {
        assertEquals(120, Factorial.calculateFactorial(5));
    }

    @Test
    public void testFactorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-1);
        });
        assertEquals("Number must be non-negative", exception.getMessage());
    }
}

