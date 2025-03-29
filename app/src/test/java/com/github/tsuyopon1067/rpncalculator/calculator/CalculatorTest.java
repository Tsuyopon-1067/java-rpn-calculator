package com.github.tsuyopon1067.rpncalculator.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;
    final double DELTA = 1.0e-10;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testCalculation_Add_2Token() {
        Result result = calculator.calc("1 2 +");
        assertEquals(3, result.getToken().getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Add_7Token() {
        Result result = calculator.calc("1 2 3 4 + + +");
        assertEquals(10, result.getToken().getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Sub_2Token() {
        Result result = calculator.calc("1 2 -");
        assertEquals(-1, result.getToken().getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Mult_2Token() {
        Result result = calculator.calc("11 2 *");
        assertEquals(22, result.getToken().getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Div_2Token() {
        Result result = calculator.calc("8 2 /");
        assertEquals(4, result.getToken().getValue(), DELTA);
        assertFalse(result.isError());
    }

    @Test
    void testCalculation_Mix() {
        // 100 - 16*6 + (3+5)/4 = 100 - 96 + 2 = 6
        Result result = calculator.calc("100 16 6 * - 3 5 + 4 / +");
        assertEquals(6, result.getToken().getValue(), DELTA);
        assertFalse(result.isError());
    }
}
