package com.github.tsuyopon1067.rpncalculator.token;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberTokenTest {

    @Test
    public void testConstructorAndGetValue() {
        NumberToken token1 = new NumberToken(42.0);
        assertEquals(42.0, token1.getValue(), 0.0001);

        NumberToken token2 = new NumberToken(-123.45);
        assertEquals(-123.45, token2.getValue(), 0.0001);

        NumberToken token3 = new NumberToken(0.0);
        assertEquals(0.0, token3.getValue(), 0.0001);

        NumberToken token4 = new NumberToken(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, token4.getValue(), 0.0001);

        NumberToken token5 = new NumberToken(Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, token5.getValue(), 0.0001);
    }

    @Test
    public void testToString() {
        NumberToken token1 = new NumberToken(42.0);
        assertEquals("42.0", token1.toString());

        NumberToken token2 = new NumberToken(3.14159);
        assertEquals("3.14159", token2.toString());

        NumberToken token3 = new NumberToken(-123.45);
        assertEquals("-123.45", token3.toString());

        NumberToken token4 = new NumberToken(0.0);
        assertEquals("0.0", token4.toString());
    }
}