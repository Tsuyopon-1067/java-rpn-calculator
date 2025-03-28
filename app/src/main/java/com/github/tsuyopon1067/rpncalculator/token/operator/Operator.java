package com.github.tsuyopon1067.rpncalculator.token.operator;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;

public interface Operator {
    public NumberToken calc(NumberToken first, NumberToken second);
}
