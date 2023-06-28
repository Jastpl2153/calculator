package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Arrays;

public class AdvancedController extends UsualController{
    @Override
    protected void processOperation(ActionEvent event) {
        String outputText = getOutput().getText();
        double[] numbers = numberPattern(outputText);

        try {
            if (outputText.matches("√\\d+(\\.\\d+)?")) {
                getOutput().setText(String.valueOf(Math.sqrt(numbers[0])));
            } else if (outputText.matches("(\\d+(\\.\\d+)?)√\\d+(\\.\\d+)?")) {
                getOutput().setText(String.valueOf(Math.sqrt(numbers[1]) * numbers[0]));
            } else if (outputText.matches("\\d+(\\.\\d+)?!")) {
                getOutput().setText(String.valueOf(factorial(numbers[0])));
            } else if (outputText.matches("\\d+(\\.\\d+)?\\^\\d+(\\.\\d+)?")) {
                getOutput().setText(String.valueOf(Math.pow(numbers[0], numbers[1])));
            } else if (outputText.matches("log\\(\\d+(\\.\\d+)?")) {
                getOutput().setText(String.valueOf(Math.log10(numbers[0])));
            } else if (outputText.matches("ln\\(\\d+(\\.\\d+)?")) {
                getOutput().setText(String.valueOf(Math.log(numbers[0])));
            } else {
                super.processOperation(event);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
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

    @FXML
    void textOperationProcess(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        String currentOutput = getOutput().getText();

        if (buttonText.equals("!") && currentOutput.equals("0") || currentOutput.equals("1")) {
            getOutput().setText(currentOutput + buttonText);
        } else if (buttonText.equals("log") || buttonText.equals("ln")) {
            getOutput().setText(buttonText + "(");
        }else if (currentOutput.equals("0") || currentOutput.equals("")) {
            getOutput().setText(buttonText);
        } else if (currentOutput.matches("\\d+(\\.\\d+)?")) {
            getOutput().setText(currentOutput + buttonText);
        }
    }

    @Override
    protected void processNumPad(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        String currentOutput = getOutput().getText();

        if (currentOutput.equals("√") || currentOutput.equals("log(") || currentOutput.equals("ln(") ) {
            if (isStart()) {
                setStart(false);
            }
            getOutput().setText(currentOutput + buttonText);
        } else {
            super.processNumPad(event);
        }
    }

    private double[] numberPattern(String input){
        String[] numbersString = Arrays.stream(input.split("[√^!]|log\\(|ln\\("))
                .filter(str -> !str.isEmpty())
                .toArray(String[]::new);

        if (numbersString.length != 0) {
            double[] numbers = new double[numbersString.length];
            for (int i = 0; i < numbersString.length; i++) {
                    numbers[i] = Double.parseDouble(numbersString[i]);
            }
            return numbers;
        } else {
            getOutput().setText("ERROR");
        }
        return null;
    }

    @FXML
    void numberPi(ActionEvent event) {
        getOutput().setText(String.valueOf(Math.PI));
    }

    @FXML
    void numberE(ActionEvent event) {
        getOutput().setText(String.valueOf(Math.E));
    }
}
