package com.example.calculator.controller.advancedFunction;

public class FactorialOperation  extends Operation{
    @Override
    public boolean matches(String input) {
        return input.matches("\\d+(\\.\\d+)?!");
    }

    @Override
    public double execute(double[] numbers) {
        return factorial(numbers[0]);
    }

    private double factorial(double number) {
        if (number < 0) {
            double factorial = -1;
            for (int i = -2; i >= number; i--) {
                factorial *= i;
            }
            return factorial;
        } else if (number == 0 || number == 1) {
            return 1;
        } else {
            double factorial = 1;
            for (double i = 2; i <= number; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}
