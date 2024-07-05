
import org.apache.commons.math3.special.Gamma;

public class Factorial {
    public static double calculateFactorial(double number) {
        if (number < 0 && number % 1 == 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative integers.");
        }
        return Gamma.gamma(number + 1);
    }

    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative integers.");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
