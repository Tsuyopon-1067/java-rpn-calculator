package com.github.tsuyopon1067.rpncalculator.token.operator;

import org.junit.jupiter.api.Test;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;

import static org.junit.jupiter.api.Assertions.*;

public class AddTest {

    @Test
    public void testAddCalculation() {
        Add op = new Add();

        NumberToken token11 = new NumberToken(12.34);
        NumberToken token12 = new NumberToken(56.78);
        NumberToken result1 = op.calc(token11, token12);
        assertEquals(69.12, result1.getValue(), 0.0001);

        NumberToken token21 = new NumberToken(12.34);
        NumberToken token22 = new NumberToken(-56.78);
        NumberToken result2 = op.calc(token21, token22);
        assertEquals(-44.44, result2.getValue(), 0.0001);

        NumberToken token31 = new NumberToken(-12.34);
        NumberToken token32 = new NumberToken(56.78);
        NumberToken result3 = op.calc(token31, token32);
        assertEquals(44.44, result3.getValue(), 0.0001);

        NumberToken token41 = new NumberToken(-12.34);
        NumberToken token42 = new NumberToken(-56.78);
        NumberToken result4 = op.calc(token41, token42);
        assertEquals(-69.12, result4.getValue(), 0.0001);
    }
}