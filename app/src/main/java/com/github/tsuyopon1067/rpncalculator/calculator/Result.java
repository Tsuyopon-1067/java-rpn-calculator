package com.github.tsuyopon1067.rpncalculator.calculator;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;

public class Result {
    private NumberToken token;
    private boolean isError;

    public Result(NumberToken token) {
        this.token = token;
        this.isError = false;
    }
    public Result() {
        this.isError = true;
    }

    public boolean isError() {
        return this.isError;
    }

    public NumberToken getToken() {
        return this.token;
    }
}
