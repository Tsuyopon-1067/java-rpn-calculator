package com.github.tsuyopon1067.rpncalculator.tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.github.tsuyopon1067.rpncalculator.token.ILLToken;
import com.github.tsuyopon1067.rpncalculator.token.NumberToken;
import com.github.tsuyopon1067.rpncalculator.token.Token;
import com.github.tsuyopon1067.rpncalculator.token.operator.*;

public class Tokenizer {
    private String expression;
    private int currentIndex = 0;

    public Tokenizer(String expression) {
        this.expression = expression;
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private boolean isOperator(char c) {
        final ArrayList<Character> operators = new ArrayList<>(
            Arrays.asList(
                '+', '-', '*', '/'
            )
        );
        return operators.contains(c);
    }

    public ArrayList<Token> read() {
        ArrayList<Token> tokens = new ArrayList<>();
        while (currentIndex < expression.length()) {
            Token token = readToken();
            if (token instanceof ILLToken) {
                // TODO error
                return tokens;
            }
            tokens.add(token);
        }
        return tokens;
    }

    public Token readToken() {
        char currentChar = expression.charAt(currentIndex);
        while (currentChar == ' ' && currentIndex < expression.length()) {
            currentIndex++;
            if (currentIndex < expression.length()) {
                currentChar = expression.charAt(currentIndex);
            }
        }
        if (isNumber(currentChar)) {
            NumberToken token = readNumber();
            return token;
        }
        if (isOperator(currentChar)) {
            currentIndex++;
            return switch(currentChar) {
                case '+' -> new Add();
                case '-' -> new Sub();
                case '*' -> new Mult();
                case '/' -> new Div();
                default -> new ILLToken();
            };
        }
        return new ILLToken();
    }

    private NumberToken readNumber() {
        char currentChar = expression.charAt(currentIndex);
        ArrayList<Character> chars = new ArrayList<>();
        do {
            chars.add(currentChar);
            currentIndex++;
            if (currentIndex >= expression.length()) {
                break;
            }
            currentChar = expression.charAt(currentIndex);
        } while(isNumber(currentChar) || currentChar == '.');
        String str = chars.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
        double value = Double.valueOf(str);
        return new NumberToken(value);
    }
}
