package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.time.LocalDate;

/**
 * Controller class for calculating the date
 */
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
    private ToggleButton plus;
    @FXML
    private ToggleButton minus;

    @FXML
    private Label labelAdd;
    @FXML
    private Label labelResult;

    private ToggleButton active;
    private Label output = new Label("");
    private ToggleButton[] toggleButtons = new ToggleButton[3];

    @FXML
    void initialize() {
        getNameMenu().setText("Добавить или вычесть дни");
        toggleButtons[0] = day;
        toggleButtons[1] = month;
        toggleButtons[2] = year;
    }

    @Override
    void handleCalculateDate(ActionEvent event) {
        LocalDate startDate = getStartDatePicker().getValue();

        if (startDate != null) {
            long countD = parseLongOrDefault(getOutputDay().getText());
            long countM = parseLongOrDefault(getOutputMonth().getText());
            long countY = parseLongOrDefault(getOutputYear().getText());

            if (plus.isSelected()) {
                startDate = startDate.plusDays(countD).plusMonths(countM).plusYears(countY);
            } else if (minus.isSelected()) {
                startDate = startDate.minusDays(countD).minusMonths(countM).minusYears(countY);
            }

            result.setText(String.valueOf(startDate));
        }
    }

    long parseLongOrDefault(String text) {
        try {
            return Long.parseLong(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    //TODO: Переработать.
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

    @Override
    protected void handleProcessNumPad(ActionEvent event) {
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

            handleCalculateDate(event);
        }
    }

    @Override
    protected void handleCleanOutput(ActionEvent event) {
        getOutputDay().setText("");
        getOutputMonth().setText("");
        getOutputYear().setText("");
        result.setText("");
        setStart(true);
    }

    @Override
    protected void handleErase(ActionEvent event) {
        if (output != null && output.getText().length() > 0) {
            String text = output.getText().substring(0, output.getText().length() - 1);
            output.setText(text);

            if (!getOutputDay().getText().isEmpty() || !getOutputMonth().getText().isEmpty() || !getOutputYear().getText().isEmpty()) {
                handleCalculateDate(event);
            }
        }
    }

    //TODO: Переработать.
    @FXML
    void actionOperation(ActionEvent event) {
        if (plus == event.getSource()) {
            plus.setSelected(true);
            plus.setDisable(true);
            plus.setStyle("-fx-background-color:  F29611; -fx-background-radius: 10; -fx-opacity: 1;");
            minus.setSelected(false);
            minus.setDisable(false);
            minus.setStyle("-fx-background-color:  #ACACAC; -fx-background-radius: 10");
            handleCalculateDate(event);
        } else {
            minus.setSelected(true);
            minus.setDisable(true);
            minus.setStyle("-fx-background-color:  F29611; -fx-background-radius: 10; -fx-opacity: 1;");
            plus.setSelected(false);
            plus.setDisable(false);
            plus.setStyle("-fx-background-color:  #ACACAC; -fx-background-radius: 10");
            handleCalculateDate(event);
        }
    }

    //TODO: переработать.
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

    private boolean trueActive(){
        for (ToggleButton b:toggleButtons) {
            if (b.isSelected()){
                return true;
            }
        }
        return false;
    }

    private Label getLabelOutput(ToggleButton active) {
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

    private ToggleButton getActionButton() {
        for (ToggleButton a : toggleButtons) {
            if (a.isSelected()) {
                return a;
            }
        }
        return null;
    }
}
