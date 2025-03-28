package com.github.tsuyopon1067.rpncalculator.token.operator;

import org.junit.jupiter.api.Test;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;

import static org.junit.jupiter.api.Assertions.*;

public class MultTest {

    @Test
    public void testMultCalculation() {
        Mult op = new Mult();

        NumberToken token11 = new NumberToken(12);
        NumberToken token12 = new NumberToken(3);
        NumberToken result1 = op.calc(token11, token12);
        assertEquals(36, result1.getValue(), 0.0001);

        NumberToken token21 = new NumberToken(3);
        NumberToken token22 = new NumberToken(12);
        NumberToken result2 = op.calc(token21, token22);
        assertEquals(36, result2.getValue(), 0.0001);

        NumberToken token31 = new NumberToken(-12);
        NumberToken token32 = new NumberToken(3);
        NumberToken result3 = op.calc(token31, token32);
        assertEquals(-36, result3.getValue(), 0.0001);

        NumberToken token41 = new NumberToken(3);
        NumberToken token42 = new NumberToken(-12);
        NumberToken result4 = op.calc(token41, token42);
        assertEquals(-36, result4.getValue(), 0.0001);

        NumberToken token51 = new NumberToken(-3);
        NumberToken token52 = new NumberToken(-12);
        NumberToken result5 = op.calc(token51, token52);
        assertEquals(36, result5.getValue(), 0.0001);
    }

    @Test
    public void testMultCalculationZero() {
        Mult op = new Mult();

        NumberToken token11 = new NumberToken(12);
        NumberToken token12 = new NumberToken(0);
        NumberToken result1 = op.calc(token11, token12);
        assertEquals(0, result1.getValue(), 0.0001);

        NumberToken token21 = new NumberToken(0);
        NumberToken token22 = new NumberToken(12);
        NumberToken result2 = op.calc(token21, token22);
        assertEquals(0, result2.getValue(), 0.0001);

        NumberToken token31 = new NumberToken(0);
        NumberToken token32 = new NumberToken(0);
        NumberToken result3 = op.calc(token11, token12);
        assertEquals(0, result3.getValue(), 0.0001);
    }
}