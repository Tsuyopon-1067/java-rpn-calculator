package com.github.tsuyopon1067.rpncalculator.calculator;

import java.util.ArrayList;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;
import com.github.tsuyopon1067.rpncalculator.token.Token;
import com.github.tsuyopon1067.rpncalculator.token.operator.Operator;

public class Calculator {
    private Stack<Token> stack;
    public Calculator() {
        this.stack = new Stack<Token>();
    }

    public Result calc(ArrayList<Token> tokens) {
        for (Token token : tokens) {
            stack.push(token);
            if (token instanceof Operator) {
                NumberToken newToken = calcOperator();
                stack.push(newToken);
            }
        }
        Token result = stack.pop();
        if (result instanceof NumberToken) {
            return new Result((NumberToken)result);
        }
        return new Result();
    }

    private NumberToken calcOperator() {
        // n2 op n1 -> [n1 n2 op]
        Token tmpOperator = stack.pop();
        Token tmpNumber2 = stack.pop();
        Token tmpNumber1 = stack.pop();
        if (!(tmpOperator instanceof Operator)
        || !(tmpNumber1 instanceof NumberToken)
        || !(tmpNumber2 instanceof NumberToken)) {
            // TODO error
            return new NumberToken(0);
        }

        Operator operator = (Operator)tmpOperator;
        NumberToken number1 = (NumberToken)tmpNumber1;
        NumberToken number2 = (NumberToken)tmpNumber2;
        return operator.calc(number1, number2);
    }
}
