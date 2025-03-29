package com.github.tsuyopon1067.rpncalculator.token.operator;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;
import com.github.tsuyopon1067.rpncalculator.token.Token;

public interface Operator extends Token {
    public NumberToken calc(NumberToken first, NumberToken second);
}
