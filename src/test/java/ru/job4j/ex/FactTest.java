package ru.job4j.ex;

import org.junit.Test;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenMinus1ThenFail() {
        new Fact().calc(-1);
    }
}