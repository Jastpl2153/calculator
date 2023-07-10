package com.example.calculator.controller.advancedFunction;

public class SquareRootOperation extends Operation{
    @Override
    public boolean matches(String input) {
        return input.matches("√\\d+(\\.\\d+)?");
    }

    @Override
    public double execute(double[] numbers) {
        return Math.sqrt(numbers[0]);
    }
}
