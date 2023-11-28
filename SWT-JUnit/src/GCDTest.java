

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GCDTest {
    @ParameterizedTest
    @CsvSource({
            "0, 5, 5",
            "5, 0, 5",
            "1, 5, 1",
            "5, 1, 1",
            "5, 5, 5",
            "-5, -5, 5",
            "10, 20, 10",
            "-10, -20, 10",
            "14, 28, 14",
            "-14, -28, 14"
    })
    public void testGcd(int a, int b, int gcd) {
        assertEquals(gcd, GCD.gcd(a, b));

    }

    @Test
    public void testGcdProperty() {
        int a = 3;
        int b = 5;
        int r = 7;
        assertEquals(GCD.gcd(a * r, b * r), GCD.gcd(a, b) * Math.abs(r));
    }
}
