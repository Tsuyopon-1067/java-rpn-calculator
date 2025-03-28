package com.github.tsuyopon1067.rpncalculator.calculator;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;

public class Result {
    private double value;
    private boolean isError;

    public Result(NumberToken token) {
        this.value = token.getValue();
        this.isError = false;
    }
    public Result() {
        this.isError = true;
    }

    public boolean isError() {
        return this.isError;
    }

    public double getValue() {
        return this.value;
    }
}
