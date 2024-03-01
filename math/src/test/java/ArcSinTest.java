import org.example.ArcSin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArcSinTest {



    @ParameterizedTest
    @MethodSource("provideTestValues")
    void testArcSinInRange(double x, double expected, int precision) {
        assertEquals(expected, ArcSin.calculateSeries(x, precision));
    }

    @Test
    void testOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> ArcSin.calculateSeries(1.1, 5));
        assertThrows(IllegalArgumentException.class, () -> ArcSin.calculateSeries(-1.1, 5));
    }

    @Test
    void testPrecisionZero() {
        assertThrows(IllegalArgumentException.class, () -> ArcSin.calculateSeries(0.5, 0));
    }

    @Test
    void testPrecisionNegative() {
        assertThrows(IllegalArgumentException.class, () -> ArcSin.calculateSeries(0.5, -5));
    }

    @Test
    void testPrecisionOverflow() {
        assertThrows(IllegalArgumentException.class, () -> ArcSin.calculateSeries(0.5, 8));
    }

    static Stream<Arguments> provideTestValues() {
        return Stream.of(
                Arguments.of(0.0, 0.0, 7),
                Arguments.of(0.25, 0.2526802551413687, 7),
                Arguments.of(-0.25, -0.2526802551413687, 7),
                Arguments.of(0.5, 0.5235986637263972, 7),
                Arguments.of(-0.5, -0.5235986637263972, 7),
                Arguments.of(0.75, 0.8478944364486694, 7),
                Arguments.of(-0.75, -0.8478944364486694, 7),
                Arguments.of(1, 1.3703812355179543, 7),
                Arguments.of(-1, -1.3703812355179543, 7)
        );
    }

}
