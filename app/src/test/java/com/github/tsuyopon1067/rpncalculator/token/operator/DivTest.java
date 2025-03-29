package com.github.tsuyopon1067.rpncalculator.token.operator;

import org.junit.jupiter.api.Test;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;

import static org.junit.jupiter.api.Assertions.*;

public class DivTest {

    @Test
    public void testMultCalculation() {
        Div op = new Div();

        NumberToken token11 = new NumberToken(12);
        NumberToken token12 = new NumberToken(3);
        NumberToken result1 = op.calc(token11, token12);
        assertEquals(4, result1.getValue(), 0.0001);

        NumberToken token21 = new NumberToken(3);
        NumberToken token22 = new NumberToken(12);
        NumberToken result2 = op.calc(token21, token22);
        assertEquals(0.25, result2.getValue(), 0.0001);

        NumberToken token31 = new NumberToken(-12);
        NumberToken token32 = new NumberToken(3);
        NumberToken result3 = op.calc(token31, token32);
        assertEquals(-4, result3.getValue(), 0.0001);

        NumberToken token41 = new NumberToken(3);
        NumberToken token42 = new NumberToken(-12);
        NumberToken result4 = op.calc(token41, token42);
        assertEquals(-0.25, result4.getValue(), 0.0001);

        NumberToken token51 = new NumberToken(-3);
        NumberToken token52 = new NumberToken(-12);
        NumberToken result5 = op.calc(token51, token52);
        assertEquals(0.25, result5.getValue(), 0.0001);
    }

    @Test
    public void testDivCalculationZero() {
        Div op = new Div();

        NumberToken token11 = new NumberToken(0);
        NumberToken token12 = new NumberToken(3);
        NumberToken result1 = op.calc(token11, token12);
        assertEquals(0, result1.getValue(), 0.0001);
    }
}