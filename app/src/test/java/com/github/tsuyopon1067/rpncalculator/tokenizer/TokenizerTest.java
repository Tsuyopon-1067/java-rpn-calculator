package com.github.tsuyopon1067.rpncalculator.tokenizer;

import org.junit.jupiter.api.Test;

import com.github.tsuyopon1067.rpncalculator.token.NumberToken;
import com.github.tsuyopon1067.rpncalculator.token.Token;
import com.github.tsuyopon1067.rpncalculator.token.operator.*;
import com.github.tsuyopon1067.tokenizer.Tokenizer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

class TokenizerTest {

    @Test
    void testTokenizer_1Token() {
        System.out.println("hogheohgoehgoheohgoe\n");
        System.out.println("hogheohgoehgoheohgoe\n");
        System.out.println("hogheohgoehgoheohgoe\n");
        System.out.println("hogheohgoehgoheohgoe\n");
        System.out.println("hogheohgoehgoheohgoe\n");
        String expression = "1";
        Tokenizer tokenizer = new Tokenizer(expression);
        ArrayList<Token> expected = new ArrayList<>(
            Arrays.asList(
                new NumberToken(1)
        ));

        ArrayList<Token> result = tokenizer.read();
        //assertEquals(result, expected);
        //assertTrue(compareTokens(expected, result));
        compareTokens(expected, result);
    }
    @Test
    void testTokenizer_Mix() {
        String expression = "1 2 3 4 56 789 +    - / * 1.234";
        Tokenizer tokenizer = new Tokenizer(expression);
        ArrayList<Token> expected = new ArrayList<>(
            Arrays.asList(
                new NumberToken(1),
                new NumberToken(2),
                new NumberToken(3),
                new NumberToken(4),
                new NumberToken(56),
                new NumberToken(789),
                new Add(),
                new Sub(),
                new Div(),
                new Mult(),
                new NumberToken(1.234)
        ));

        ArrayList<Token> result = tokenizer.read();
        //assertTrue(result.equals(expected));
        compareTokens(expected, result);
    }

    void compareTokens(ArrayList<Token> list1, ArrayList<Token> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (i >= list2.size()) {
                assertFalse(true);
            }
            Token item1 = list1.get(i);
            Token item2 = list2.get(i);
            if (item1 instanceof NumberToken && item2 instanceof NumberToken) {
                double value1 = ((NumberToken)(item1)).getValue();
                double value2 = ((NumberToken)(item2)).getValue();
                assertEquals(value1, value2, 0.0001);
            } else {
                assertEquals(item1.getClass(), item2.getClass());
            }
        }
    }
}