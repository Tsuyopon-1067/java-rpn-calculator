package com.github.tsuyopon1067.rpncalculator.token;

public class NumberToken implements Token {
    private double value;

    public NumberToken(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public double getValue() {
        return value;
    }
}
