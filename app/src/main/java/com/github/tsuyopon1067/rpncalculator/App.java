/*
 * This source file was generated by the Gradle 'init' task
 */
package com.github.tsuyopon1067.rpncalculator;

import java.util.Scanner;

import com.github.tsuyopon1067.rpncalculator.calculator.Calculator;
import com.github.tsuyopon1067.rpncalculator.calculator.Result;
import com.github.tsuyopon1067.rpncalculator.token.NumberToken;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.err.print("expression: ");
        String expression = scanner.nextLine();
        Result result = calculator.calc(expression);
        if (result.isError()) {
            System.err.println("error occured.");
            System.err.println("result token: " + result.getToken().getClass());
        }
        System.err.println("result: " + ((NumberToken)result.getToken()).getValue());

        scanner.close();
    }
}
