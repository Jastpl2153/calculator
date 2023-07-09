package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Arrays;

public class AdvancedController extends UsualController{

    @FXML
    private Button deg;
    @FXML
    private Button rad;
    private boolean radOrDeg = true;

    @Override
    protected void handleProcessOperation(ActionEvent event) {
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
            } else if (outputText.matches("log \\d+(\\.\\d+)?")) {
                getOutput().setText(String.valueOf(Math.log10(numbers[0])));
            } else if (outputText.matches("ln \\d+(\\.\\d+)?")) {
                getOutput().setText(String.valueOf(Math.log(numbers[0])));
            } else {
                super.handleProcessOperation(event);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void textOperationProcess(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        String currentOutput = getOutput().getText();

        if (buttonText.equals("!")) { // Услови для факториала
            getOutput().setText(currentOutput + buttonText);
        } else if (buttonText.equals("log") || buttonText.equals("ln")) { // Условие для лог...
            getOutput().setText(buttonText + " ");
        }else if (currentOutput.equals("0") || currentOutput.equals("")) {
            getOutput().setText(buttonText);
        } else if (currentOutput.matches("\\d+(\\.\\d+)?")) { //Условие для корня
            getOutput().setText(currentOutput + buttonText);
        }
    }

    @Override
    protected void handleProcessNumPad(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        String currentOutput = getOutput().getText();

        if (currentOutput.equals("√") || currentOutput.equals("log ") || currentOutput.equals("ln ") ) {
            setStart(false);
            getOutput().setText(currentOutput + buttonText);
        } else {
            super.handleProcessNumPad(event);
        }
    }

    private double[] numberPattern(String input){
        String[] numbersString = Arrays.stream(input.split("[√^!]|log |ln "))
                .filter(str -> !str.isEmpty())
                .toArray(String[]::new);

        if (numbersString.length != 0) {
            double[] numbers = new double[numbersString.length];
            for (int i = 0; i < numbersString.length; i++) {
                    numbers[i] = Double.parseDouble(numbersString[i]);
            }
            return numbers;
        }
        return null;
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
    private void numberPi(ActionEvent event) {
        getOutput().setText(String.valueOf(Math.PI));
    }

    @FXML
    private void numberE(ActionEvent event) {
        getOutput().setText(String.valueOf(Math.E));
    }

    @FXML
    private void processAbc (ActionEvent event) {
        if (getOutput().getText().matches("-?\\d+(\\.\\d+)?")) {
            double num = Double.parseDouble(getOutput().getText());
            if (num > 0) {
                num = -Math.abs(num);
                getOutput().setText(round(num));
            } else {
                num = Math.abs(num);
                getOutput().setText(round(num));
            }
        }
    }

    @FXML
    private void fibonacci(ActionEvent event) {
        int number = 0;
        try {
            number = Integer.parseInt(getOutput().getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        if (number <= 0) {
             getOutput().setText("0");
        } else if (number == 1 || number == 2) {
            getOutput().setText("1");
        } else {
            int fib1 = 1;
            int fib2 = 1;
            int fibonacci = 0;

            for (int i = 3; i <= number; i++) {
                fibonacci = fib1 + fib2;
                fib1 = fib2;
                fib2 = fibonacci;
            }

            getOutput().setText(Integer.toString(fibonacci));
        }
    }

    @FXML
    void radOrDeg(ActionEvent event) {
        String name = ((Button) event.getSource()).getText();
        if (name.equals("rad")) {
            radOrDeg = true;
            rad.setStyle("-fx-background-color:  F29611; -fx-background-radius: 30 30 0 0");
            deg.setStyle("-fx-background-color: #ACACAC; -fx-background-radius: 0 0 30 30");
        } else {
            radOrDeg = false;
            rad.setStyle("-fx-background-color: #ACACAC; -fx-background-radius: 30 30 0 0");
            deg.setStyle("-fx-background-color:  F29611; -fx-background-radius: 0 0 30 30");
        }
    }

    @FXML
    void sin(ActionEvent event) {
        if (!getOutput().getText().isEmpty()) {
            Double number = Double.parseDouble(getOutput().getText());
            getInfo().setText("sin " + number);
            if (radOrDeg == true) {
                double result = Math.sin(number);
                getOutput().setText(String.valueOf(result));
            } else {
                double angleRadians = Math.toRadians(number);
                double sinValue = Math.sin(angleRadians);
                getOutput().setText(String.valueOf(sinValue));
            }
        }else {
            getOutput().setText("ERROR");
        }
    }

    @FXML
    void cos(ActionEvent event) {
        if (!getOutput().getText().isEmpty()) {
            Double number = Double.parseDouble(getOutput().getText());
            getInfo().setText("cos " + number);
            if (radOrDeg == true) {
                double result = Math.cos(number);
                getOutput().setText(String.valueOf(result));
            } else {
                double angleRadians = Math.toRadians(number);
                double sinValue = Math.cos(angleRadians);
                getOutput().setText(String.valueOf(sinValue));
            }
        }else {
            getOutput().setText("ERROR");
        }
    }

    @FXML
    void tan(ActionEvent event) {
        if (!getOutput().getText().isEmpty()) {
            Double number = Double.parseDouble(getOutput().getText());
            getInfo().setText("tan " + number);
            if (radOrDeg == true) {
                double result = Math.tan(number);
                getOutput().setText(String.valueOf(result));
            } else {
                double angleRadians = Math.toRadians(number);
                double sinValue = Math.tan(angleRadians);
                getOutput().setText(String.valueOf(sinValue));
            }
        }else {
            getOutput().setText("ERROR");
        }
    }
}
