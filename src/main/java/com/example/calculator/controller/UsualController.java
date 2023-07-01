package com.example.calculator.controller;

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

public class UsualController {
    @FXML
    private MenuItem converterCalc;
    @FXML
    private MenuItem advancedCalc;
    @FXML
    private MenuItem usualCalc;
    @FXML
    private VBox window;
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
    protected void typeCalc(ActionEvent event) {
        if (event.getSource() == advancedCalc) {
            setTypeCalcScene("/com/example/calculator/AdvancedCalc.fxml", 333, 629);
        } else if (event.getSource() == usualCalc) {
            setTypeCalcScene("/com/example/calculator/UsualCalc.fxml", 298, 537);
        } else if (event.getSource() == converterCalc) {
            setTypeCalcScene("/com/example/calculator/ConverterCalc.fxml", 298, 537);
        }
    }

    private void setTypeCalcScene(String fxmlPath, double width, double height) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root, width, height);
            Stage stage = (Stage) window.getScene().getWindow();
            stage.setScene(scene);

            UsualController controller = loader.getController();
            controller.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void style(ActionEvent event) {
        String backgroundColor;
        String textColor;

        if (window.getStyle().equals("-fx-background-color: #111111;")) {
            backgroundColor = "white";
            textColor = "#111111";
        } else {
            backgroundColor = "#111111";
            textColor = "white";
        }

        window.setStyle("-fx-background-color: " + backgroundColor + ";");
        colorStyle.setStyle("-fx-background-color: " + textColor + "; -fx-text-fill: " + backgroundColor + "; -fx-background-radius: 50");
        output.setStyle("-fx-text-fill: " + textColor + ";");
        info.setStyle("-fx-text-fill: " + textColor + ";");
    }

    @FXML
    protected void processNumPad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    protected void processOperation(ActionEvent event) {
        if (output.getText().equals("ERROR")) {
            return;
        }
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operation.isEmpty()) {
                return;
            }
            operation = value;
            info.setText(output.getText() + operation);
            num = Double.parseDouble(output.getText());
            output.setText("");
        } else {
            if (operation.isEmpty() || output.getText().isEmpty() || output.getText().equals(".")) {
                output.setText("ERROR");
                operation = "";
            } else {
                info.setText(info.getText() + output.getText());
                String result = calculate(num, Double.parseDouble(output.getText()), operation);
                rounding(result);
                operation = "";
                start = true;
            }
        }
    }

    @FXML
    protected void cleanOutput(ActionEvent event) {
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

    protected void rounding(String num) {
        String regex = "-?\\d+\\.0*";
        if (num.matches(regex)) {
            long result = (long) Double.parseDouble(num);
            output.setText(String.valueOf(result));
        } else {
            output.setText(num);
        }
    }

    @FXML
    protected void erase(ActionEvent event) {
        String text = output.getText();
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
            output.setText(text);
        }
    }

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

    public void setInfo(Label info) {
        this.info = info;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
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
