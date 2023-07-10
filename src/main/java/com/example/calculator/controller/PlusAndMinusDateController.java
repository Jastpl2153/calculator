package com.example.calculator.controller;

import com.example.calculator.controller.styles.Styles;
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

    @FXML
    void handleToggleButtons(ActionEvent event) {
        ToggleButton action = (ToggleButton) event.getSource();
        for (ToggleButton a : toggleButtons) {
            if (a == action) {
                a.setSelected(true);
                a.setDisable(true);
                Styles.applyActiveStyle(a);
                active = getActionButton();
                output = getLabelOutput(active);
            } else {
                a.setSelected(false);
                a.setDisable(false);
                Styles.applyInactiveStyle(a);
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

    @FXML
    void handleActionOperation(ActionEvent event) {
        ToggleButton selectedButton = (ToggleButton) event.getSource();
        ToggleButton otherButton = (selectedButton == plus) ? minus : plus;

        selectedButton.setSelected(true);
        selectedButton.setDisable(true);
        Styles.applyActiveStyle(selectedButton);

        otherButton.setSelected(false);
        otherButton.setDisable(false);
        Styles.applyInactiveStyle(otherButton);

        handleCalculateDate(event);
    }

    @Override
    void style(ActionEvent event) {
        if (getWindow().getStyle().equals("-fx-background-color: #111111;")) {
            Styles.applyLightStyle(getWindow(), getColorStyle(), getLabelStart(), labelAdd, labelResult);
        } else {
            Styles.applyDarkStyle(getWindow(), getColorStyle(), getLabelStart(), labelAdd, labelResult);
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
