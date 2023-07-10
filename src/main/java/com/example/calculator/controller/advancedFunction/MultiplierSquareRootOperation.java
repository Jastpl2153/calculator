package com.example.calculator.controller.advancedFunction;

public class MultiplierSquareRootOperation  extends Operation{
    @Override
    public boolean matches(String input) {
        return input.matches("(\\d+(\\.\\d+)?)√\\d+(\\.\\d+)?");
    }

    @Override
    public double execute(double[] numbers) {
        return Math.sqrt(numbers[1]) * numbers[0];
    }
}
