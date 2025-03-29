package com.github.tsuyopon1067.rpncalculator.calculator;

import com.github.tsuyopon1067.tokenizer.Tokenizer;

public class Calculator {
    public Result calc(String expression) {
        Tokenizer tokenizer = new Tokenizer(expression);
        StackCalculator stackCalculator = new StackCalculator();
        var tokens = tokenizer.read();
        return stackCalculator.calc(tokens);
    }
}
