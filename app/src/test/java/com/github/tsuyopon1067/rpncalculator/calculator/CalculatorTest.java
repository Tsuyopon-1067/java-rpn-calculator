package com.github.tsuyopon1067.rpncalculator.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;
import com.github.tsuyopon1067.rpncalculator.token.Token;
import com.github.tsuyopon1067.rpncalculator.token.operator.Add;
import com.github.tsuyopon1067.rpncalculator.token.operator.Div;
import com.github.tsuyopon1067.rpncalculator.token.operator.Mult;
import com.github.tsuyopon1067.rpncalculator.token.operator.Sub;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CalculatorTest {
    private Calculator calculator;
    final double DELTA = 1.0e-10;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testCalculation_Add_2Token() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new NumberToken(1));
        tokens.add(new NumberToken(2));
        tokens.add(new Add());
        Result result = calculator.calc(tokens);
        assertEquals(3, result.getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Add_7Token() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new NumberToken(1));
        tokens.add(new NumberToken(2));
        tokens.add(new NumberToken(3));
        tokens.add(new NumberToken(4));
        tokens.add(new Add());
        tokens.add(new Add());
        tokens.add(new Add());
        Result result = calculator.calc(tokens);
        assertEquals(10, result.getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Sub_2Token() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new NumberToken(1));
        tokens.add(new NumberToken(2));
        tokens.add(new Sub());
        Result result = calculator.calc(tokens);
        assertEquals(-1, result.getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Mult_2Token() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new NumberToken(11));
        tokens.add(new NumberToken(2));
        tokens.add(new Mult());
        Result result = calculator.calc(tokens);
        assertEquals(22, result.getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Div_2Token() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new NumberToken(8));
        tokens.add(new NumberToken(2));
        tokens.add(new Div());
        Result result = calculator.calc(tokens);
        assertEquals(4, result.getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Mix() {
        // 100 - 16*6 + (3+5)/4 = 100 - 96 + 2 = 6
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new NumberToken(100));
        tokens.add(new NumberToken(16));
        tokens.add(new NumberToken(6));
        tokens.add(new Mult());
        tokens.add(new Sub());
        tokens.add(new NumberToken(3));
        tokens.add(new NumberToken(5));
        tokens.add(new Add());
        tokens.add(new NumberToken(4));
        tokens.add(new Div());
        tokens.add(new Add());
        Result result = calculator.calc(tokens);
        assertEquals(6, result.getValue(), DELTA);
        assertFalse(result.isError());
    }
}
