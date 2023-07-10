package com.example.calculator.controller.advancedFunction;

public class PowOperation  extends Operation{
    @Override
    public boolean matches(String input) {
        return input.matches("\\d+(\\.\\d+)?\\^\\d+(\\.\\d+)?");
    }

    @Override
    public double execute(double[] numbers) {
        return Math.pow(numbers[0], numbers[1]);
    }
}
