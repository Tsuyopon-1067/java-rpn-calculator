package com.github.tsuyopon1067.rpncalculator.token.operator;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;

public class Mult implements Operator {
    @Override
    public NumberToken calc(NumberToken first, NumberToken second) {
        return new NumberToken(first.getValue() * second.getValue());
    }
}
