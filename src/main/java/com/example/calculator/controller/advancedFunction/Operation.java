package com.example.calculator.controller.advancedFunction;

public abstract class Operation {
    public abstract boolean matches(String input);
    public abstract double execute(double[] numbers);
}