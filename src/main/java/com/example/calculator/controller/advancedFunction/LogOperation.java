package com.example.calculator.controller.advancedFunction;

public class LogOperation  extends Operation{
    @Override
    public boolean matches(String input) {
        return input.matches("log \\d+(\\.\\d+)?");
    }

    @Override
    public double execute(double[] numbers) {
        return Math.log10(numbers[0]);
    }
}
