package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final static double EPS = 1e-6;

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testF1() {
        double x = 1;
        double expected = 6.5;
        double result = main.f(x);
        assertEquals(expected, result, EPS);
    }

    @Test
    void testF2() {
        double x = 2;
        double expected = 0.98386991;
        double result = main.f(x);
        assertEquals(expected, result, EPS);
    }

    @Test
    void testF3() {
        double x = 1.4;
        double result = main.f(x);
        double expected = 3.720465053;
        assertEquals(expected, result, EPS);
    }

    @Test
    void testSteps() {
        double start = 0;
        double finish = 10;
        double step = 0.1;
        int expected = 101;
        int result = main.steps(start, finish, step);
        assertEquals(expected, result);
    }

    @Test
    void testFillX() {
        double start = 0;
        double finish = 2;
        double step = 0.002;
        double[] expected = {0, 1.4, 2};
        double[] result = main.fillX(start, finish, step);
        assertEquals(expected[0], result[0], EPS);
        assertEquals(expected[1], result[700], EPS);
        assertEquals(expected[2], result[1000], EPS);
    }

    @Test
    void testFillY() {
        double start = 0;
        double finish = 2;
        double step = 0.002;
        double[] x = main.fillX(start, finish, step);
        double[] expected = {4.0, 3.720465053, 0.98386991};
        double[] result = main.fillY(x);
        assertEquals(expected[0], result[0], EPS);
        assertEquals(expected[1], result[700], EPS);
        assertEquals(expected[2], result[1000], EPS);
    }

    @Test
    void testSum() {
        double[] arr = {1.0, -2.1, 7.5, 4.3, 11.6};
        double expected = 22.3;
        double result = main.sum(arr);
        assertEquals(expected, result, EPS);
    }

    @Test
    void testMin() {
        double[] arr = {1.0, -2.1, 7.5, 4.3, 11.6};
        int expected = 1;
        double result = main.numMin(arr);
        assertEquals(expected,result);
    }
}