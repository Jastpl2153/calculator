package com.example.calculator.controller;

import com.example.calculator.controller.advancedFunction.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedController extends UsualController{
    @FXML
    private Button deg;
    @FXML
    private Button rad;
    private boolean radOrDeg = true;
    private List<Operation> operations;

    public AdvancedController() {
        operations = new ArrayList<>();
        operations.add(new SquareRootOperation());
        operations.add(new MultiplierSquareRootOperation());
        operations.add(new FactorialOperation());
        operations.add(new PowOperation());
        operations.add(new LogOperation());
        operations.add(new LnOperation());
    }
    @Override
    protected void handleProcessNumPad(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        String currentOutput = getOutput().getText();

        if (currentOutput.equals("√") || currentOutput.equals("log ") || currentOutput.equals("ln ")) {
            setStart(false);
            getOutput().setText(currentOutput + buttonText);
        } else {
            super.handleProcessNumPad(event);
        }
    }

    @Override
    protected void handleProcessOperation(ActionEvent event) {
        String outputText = getOutput().getText();
        double[] numbers = extractNumbersFromString(outputText);

        for (Operation operation : operations) {
            if (operation.matches(outputText)) {
                getOutput().setText(round(operation.execute(numbers)));
                return;
            }
        }

        super.handleProcessOperation(event);
    }

    @FXML
    private void handleTextOperation(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        String currentOutput = getOutput().getText();

        if (buttonText.equals("!")) {
            getOutput().setText(currentOutput + buttonText);
        } else if (buttonText.equals("log") || buttonText.equals("ln")) {
            getOutput().setText(buttonText + " ");
        } else if (currentOutput.equals("0") || currentOutput.equals("")) {
            getOutput().setText(buttonText);
        } else if (currentOutput.matches("\\d+(\\.\\d+)?")) { //Условие для корня
            getOutput().setText(currentOutput + buttonText);
        }
    }

    private double[] extractNumbersFromString(String input){
        String[] numberStrings = input.split("[√^!]|log |ln ");
        return Arrays.stream(numberStrings)
                .filter(str -> !str.isEmpty())
                .mapToDouble(Double::parseDouble)
                .toArray();
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
    private void processAbc(ActionEvent event) {
        String outputText = getOutput().getText();
        if (outputText.matches("-?\\d+(\\.\\d+)?")) {
            double num = Double.parseDouble(outputText);
            num = (num > 0) ? -Math.abs(num) : Math.abs(num);
            getOutput().setText(round(num));
        }
    }

    @FXML
    private void fibonacci(ActionEvent event) {
        int number;
        try {
            number = Integer.parseInt(getOutput().getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        int fib1 = 1;
        int fib2 = 1;
        int fibonacci = 0;

        if (number <= 0) {
            fibonacci = 0;
        } else if (number == 1 || number == 2) {
            fibonacci = 1;
        } else {
            for (int i = 3; i <= number; i++) {
                fibonacci = fib1 + fib2;
                fib1 = fib2;
                fib2 = fibonacci;
            }
        }

        getOutput().setText(Integer.toString(fibonacci));
    }

    //TODO: Добавить классу стиля.
    @FXML
    private void radOrDeg(ActionEvent event) {
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
    private void sin(ActionEvent event) {
        if (!getOutput().getText().isEmpty()) {
            Double number = Double.parseDouble(getOutput().getText());
            getInfo().setText("sin " + number);
            double result = radOrDeg ? Math.sin(number) : Math.sin(Math.toRadians(number));
            getOutput().setText(String.valueOf(result));
        } else {
            getOutput().setText("ERROR");
        }
    }

    @FXML
    private void cos(ActionEvent event) {
        if (!getOutput().getText().isEmpty()) {
            Double number = Double.parseDouble(getOutput().getText());
            getInfo().setText("cos " + number);
            double result = radOrDeg ? Math.cos(number) : Math.cos(Math.toRadians(number));
            getOutput().setText(String.valueOf(result));
        } else {
            getOutput().setText("ERROR");
        }
    }

    @FXML
    private void tan(ActionEvent event) {
        if (!getOutput().getText().isEmpty()) {
            Double number = Double.parseDouble(getOutput().getText());
            getInfo().setText("tan " + number);
            double result = radOrDeg ? Math.tan(number) : Math.tan(Math.toRadians(number));
            getOutput().setText(String.valueOf(result));
        } else {
            getOutput().setText("ERROR");
        }
    }
}
