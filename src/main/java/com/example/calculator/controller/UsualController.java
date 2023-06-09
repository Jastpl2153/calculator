package com.example.calculator.controller;

import com.example.calculator.controller.styles.Styles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Basic controller for a regular calculator.
 * Also a parent class for other types of calculators.
 */

public class UsualController {
    @FXML
    private VBox window;

    @FXML
    private MenuItem usualCalc;
    @FXML
    private MenuItem advancedCalc;
    @FXML
    private MenuItem converterCalc;
    @FXML
    private MenuItem dateCalc;
    @FXML
    private MenuItem systemNumberCalc;

    @FXML
    private Button colorStyle;

    @FXML
    private Label info;
    @FXML
    private Label output;

    private Scene scene;
    private double num;
    private String operation = "";
    private boolean start = true;

    @FXML
    protected void handleTypeCalc(ActionEvent event) {
        if (event.getSource() == usualCalc) {
            setTypeCalcScene("/com/example/calculator/UsualCalc.fxml", 298, 537);
        } else if (event.getSource() == advancedCalc) {
            setTypeCalcScene("/com/example/calculator/AdvancedCalc.fxml", 333, 629);
        } else if (event.getSource() == converterCalc) {
            setTypeCalcScene("/com/example/calculator/ConverterCalc.fxml", 298, 537);
        } else if (event.getSource() == dateCalc) {
            setTypeCalcScene("/com/example/calculator/DifferenceDateCalc.fxml", 298, 537);
        } else if (event.getSource() == systemNumberCalc) {
            setTypeCalcScene("/com/example/calculator/NumberSystem.fxml", 333, 629);
        }
    }

    @FXML
    void style(ActionEvent event) {
        if (window.getStyle().equals("-fx-background-color: " + Styles.COLOR_BLACK + ";")) {
            Styles.applyLightStyle(window, colorStyle, output, info);
        } else {
            Styles.applyDarkStyle(window, colorStyle, output, info);
        }
    }

    @FXML
    protected void handleProcessNumPad(ActionEvent event) {
        if (start && !output.getText().equals("-")) {
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    protected void handleProcessOperation(ActionEvent event) {
        if (output.getText().equals("ERROR")) {
            return;
        }

        String value = ((Button) event.getSource()).getText();

        if (!value.equals("=")) {
            handleNonEqualsOperation(value);
        } else {
            handleEqualsOperation();
        }
    }

    protected void handleNonEqualsOperation(String value) {
        if (output.getText().isEmpty() && value.equals("-") && info.getText().isEmpty()) {
            output.setText("-");
            return;
        }

        if (operation.isEmpty()) {
            num = Double.parseDouble(output.getText());
            operation = value;
        } else {
            operation = value;
            info.setText(round(num) + operation);
        }

        info.setText(output.getText() + operation);
        output.setText("");
    }

    protected void handleEqualsOperation() {
        if (operation.isEmpty() || output.getText().isEmpty() || output.getText().equals(".")) {
            output.setText("ERROR");
            operation = "";
        } else {
            info.setText(info.getText() + output.getText());
            output.setText(round(Double.parseDouble(calculate(num, Double.parseDouble(output.getText()), operation))));
            operation = "";
            start = true;
        }
    }

    @FXML
    protected void handleCleanOutput(ActionEvent event) {
        output.setText("");
        info.setText("");
        start = true;
        operation = "";
    }

    public String calculate(double num1, double num2, String op) {
        switch (op) {
            case "+" -> {
                return String.valueOf(num1 + num2);
            }
            case "-" -> {
                return String.valueOf(num1 - num2);
            }
            case "×" -> {
                return String.valueOf(num1 * num2);
            }
            case "÷" -> {
                if (num2 == 0) {
                    return "ERROR";
                }
                return String.valueOf(num1 / num2);
            }
            case "%" -> {
                return String.valueOf(num1 * num2 / 100);
            }
            default -> {
                return "ERROR";
            }
        }
    }

    protected String round(double num) {
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        return decimalFormat.format(num);
    }

    @FXML
    protected void handleErase(ActionEvent event) {
        String text = output.getText();
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
            output.setText(text);
        }
    }

    protected void setTypeCalcScene(String fxmlPath, double width, double height) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root, width, height);
            Stage stage = (Stage) window.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getter and setter

    public Label getOutput() {
        return output;
    }

    public void setOutput(Label output) {
        this.output = output;
    }

    public MenuItem getAdvancedCalc() {
        return advancedCalc;
    }

    public void setAdvancedCalc(MenuItem advancedCalc) {
        this.advancedCalc = advancedCalc;
    }

    public MenuItem getUsualCalc() {
        return usualCalc;
    }

    public void setUsualCalc(MenuItem usualCalc) {
        this.usualCalc = usualCalc;
    }

    public VBox getWindow() {
        return window;
    }

    public void setWindow(VBox window) {
        this.window = window;
    }

    public Button getColorStyle() {
        return colorStyle;
    }

    public void setColorStyle(Button colorStyle) {
        this.colorStyle = colorStyle;
    }

    public Label getInfo() {
        return info;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }
}
