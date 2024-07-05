
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorialInteger() {
        assertEquals(120, Factorial.calculateFactorial(5));
    }

    @Test
    public void testFactorialFractional() {
        assertEquals(11.631728, Factorial.calculateFactorial(3.5), 0.0001);
    }

    @Test
    public void testFactorialZero() {
        assertEquals(1, Factorial.calculateFactorial(0));
    }

    @Test
    public void testFactorialNegativeInteger() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-1);
        });
        assertEquals("Factorial is not defined for negative integers.", exception.getMessage());
    }

    @Test
    public void testFactorialNegativeFractional() {
        assertEquals(1.772453850905516, Factorial.calculateFactorial(-0.5), 0.0001);
    }

    @Test
    public void testFactorialPositiveInteger() {
        assertEquals(720, Factorial.calculateFactorial(6));
    }
}
