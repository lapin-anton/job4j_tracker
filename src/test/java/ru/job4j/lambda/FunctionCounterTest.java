package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionCounterTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCounter fc = new FunctionCounter();
        List<Double> result = fc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        FunctionCounter fc = new FunctionCounter();
        List<Double> result = fc.diapason(0, 3, x -> x * x + 1);
        List<Double> expected = Arrays.asList(1D, 2D, 5D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionCounter fc = new FunctionCounter();
        List<Double> result = fc.diapason(0, 3, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(2D, 3D, 5D);
        assertThat(result, is(expected));
    }
}