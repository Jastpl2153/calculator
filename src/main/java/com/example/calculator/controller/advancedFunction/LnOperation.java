package com.example.calculator.controller.advancedFunction;

public class LnOperation extends Operation{
    @Override
    public boolean matches(String input) {
        return input.matches("ln \\d+(\\.\\d+)?");
    }

    @Override
    public double execute(double[] numbers) {
        return Math.log(numbers[0]);
    }
}
