package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.time.LocalDate;

public class PlusAndMinusDateController extends DifferenceDateController {
    @FXML
    private ToggleButton day;

    @FXML
    private ToggleButton month;

    @FXML
    private ToggleButton year;

    @FXML
    private Label result;

    @FXML
    private ToggleButton minus;

    @FXML
    private ToggleButton plus;

    private ToggleButton active;
    @FXML
    private Label labelAdd;

    @FXML
    private Label labelResult;
    private Label output = new Label("");
    private ToggleButton[] toggleButtons = new ToggleButton[3];

    @FXML
    void initialize() {
        getNameMenu().setText("Добавить или вычесть дни");
        toggleButtons[0] = day;
        toggleButtons[1] = month;
        toggleButtons[2] = year;
    }

    @FXML
    void buttonAction(ActionEvent event) {
        ToggleButton action = (ToggleButton) event.getSource();
        for (ToggleButton a : toggleButtons) {
            if (a == action) {
                a.setSelected(true);
                a.setDisable(true);
                action.setStyle("-fx-background-color:  F29611; -fx-background-radius: 10; -fx-opacity: 1;");
                active = getActionButton();
                output = getLabelOutput(active);
            } else {
                a.setSelected(false);
                a.setDisable(false);
                a.setStyle("-fx-background-color:  #ACACAC; -fx-background-radius: 10");
            }
        }
    }

    private Label getLabelOutput(ToggleButton active){
        if (active.isSelected()) {
            if (active.equals(day)) {
                return getOutputDay();
            } else if (active.equals(month)) {
                return getOutputMonth();
            } else if (active.equals(year)) {
                return getOutputYear();
            }
        }
        return null;
    }

    private ToggleButton getActionButton(){
        for (ToggleButton a : toggleButtons) {
            if (a.isSelected()){
                return a;
            }
        }
        return null;
    }

    @Override
    protected void processNumPad(ActionEvent event) {
        if (isStart()) {
            setStart(false);
        }
        if (trueActive()) {
            String value = ((Button) event.getSource()).getText();
            if (day.isSelected()) {
                getOutputDay().setText(getOutputDay().getText() + value);
            } else if (month.isSelected()) {
                getOutputMonth().setText(getOutputMonth().getText() + value);
            } else if (year.isSelected()) {
                getOutputYear().setText(getOutputYear().getText() + value);
            }
            calculateDate(event);
        }
    }

    private boolean trueActive(){
        for (ToggleButton b:toggleButtons) {
            if (b.isSelected()){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void cleanOutput(ActionEvent event) {
        getOutputDay().setText("");
        getOutputMonth().setText("");
        getOutputYear().setText("");
        result.setText("");
        getOutputDay().setText("");
        getOutputMonth().setText("");
        getOutputYear().setText("");
        setStart(true);
    }

    @Override
    protected void erase(ActionEvent event) {
        if (output != null) {
            String text = output.getText();
            if (text.length() > 0) {
                text = text.substring(0, text.length() - 1);
                output.setText(text);
                if (!getOutputDay().getText().isEmpty() || !getOutputMonth().getText().isEmpty() || !getOutputYear().getText().isEmpty()){
                    calculateDate(event);
                }
            }
        }
    }

    @FXML
    void actionOperation(ActionEvent event) {
        if (plus == event.getSource()) {
            plus.setSelected(true);
            plus.setDisable(true);
            plus.setStyle("-fx-background-color:  F29611; -fx-background-radius: 10; -fx-opacity: 1;");
            minus.setSelected(false);
            minus.setDisable(false);
            minus.setStyle("-fx-background-color:  #ACACAC; -fx-background-radius: 10");
            calculateDate(event);
        } else {
            minus.setSelected(true);
            minus.setDisable(true);
            minus.setStyle("-fx-background-color:  F29611; -fx-background-radius: 10; -fx-opacity: 1;");
            plus.setSelected(false);
            plus.setDisable(false);
            plus.setStyle("-fx-background-color:  #ACACAC; -fx-background-radius: 10");
            calculateDate(event);
        }

    }

    @Override
    void calculateDate(ActionEvent event) {
        if (getStartDatePicker().getValue() != null && (!getOutputDay().getText().isEmpty() || !getOutputMonth().getText().isEmpty() || !getOutputYear().getText().isEmpty())) {
            LocalDate startDate = getStartDatePicker().getValue();
            long countD;
            long countM;
            long countY;
            if (plus.isSelected()) {
                if (getOutputDay() != null && !getOutputDay().getText().isEmpty()) {
                    countD = Long.parseLong(getOutputDay().getText());
                    startDate = startDate.plusDays(countD);
                    result.setText(String.valueOf(startDate));
                }
                if (getOutputMonth() != null && !getOutputMonth().getText().isEmpty()) {
                    countM = Long.parseLong(getOutputMonth().getText());
                    startDate = startDate.plusMonths(countM);
                    result.setText(String.valueOf(startDate));
                }
                if (getOutputYear() != null && !getOutputYear().getText().isEmpty()){
                    countY = Long.parseLong(getOutputYear().getText());
                    startDate = startDate.plusYears(countY);
                    result.setText(String.valueOf(startDate));
                }
            } else if (minus.isSelected()) {
                if (getOutputDay() != null && !getOutputDay().getText().isEmpty()) {
                    countD = Long.parseLong(getOutputDay().getText());
                    startDate = startDate.minusDays(countD);
                    result.setText(String.valueOf(startDate));
                }
                if (getOutputMonth() != null && !getOutputMonth().getText().isEmpty()) {
                    countM = Long.parseLong(getOutputMonth().getText());
                    startDate = startDate.minusMonths(countM);
                    result.setText(String.valueOf(startDate));
                }
                if (getOutputYear() != null && !getOutputYear().getText().isEmpty()){
                    countY = Long.parseLong(getOutputYear().getText());
                    startDate = startDate.minusYears(countY);
                    result.setText(String.valueOf(startDate));
                }
            }
        }
    }

    @Override
    void style(ActionEvent event) {
        String backgroundColor;
        String textColor;

        if (getWindow().getStyle().equals("-fx-background-color: #111111;")) {
            backgroundColor = "white";
            textColor = "#111111";
        } else {
            backgroundColor = "#111111";
            textColor = "white";
        }

        getLabelStart().setStyle("-fx-text-fill: " + textColor + ";");
        labelAdd.setStyle("-fx-text-fill: " + textColor + ";");
        labelResult.setStyle("-fx-text-fill: " + textColor + ";");
        getWindow().setStyle("-fx-background-color: " + backgroundColor + ";");
        getColorStyle().setStyle("-fx-background-color: " + textColor + "; -fx-text-fill: " + backgroundColor + "; -fx-background-radius: 50");
    }
}
