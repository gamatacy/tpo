package org.example;

public class ArcSin {
    private static final int PRECISION_LIMIT = 7;

    public static double calculateSeries(double point, int precision) {

        if (Math.abs(point) > 1) {
            throw new IllegalArgumentException("x must be in [-1, 1]");
        }
        if (precision <= 0 || precision > PRECISION_LIMIT) {
            throw new IllegalArgumentException("precision must be in (0;7]");
        }

        double last = point;
        double sum = last;
        for (int i = 1; i <= precision; i++) {
            last *= ((point * point) * (2 * i - 1) * (2 * i - 1)) / ((2 * i) * (2 * i + 1));
            sum += last;
        }

        return sum;
    }

}
