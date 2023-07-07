package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class DifferenceDateController extends UsualController  {
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private DatePicker startDatePicker;

    @FXML
    private Label outputDay;
    @FXML
    private Label outputMonth;
    @FXML
    private Label outputYear;

    @FXML
    private MenuItem differenceBetweenDates;
    @FXML
    private MenuItem plusOrMinusDate;
    @FXML
    private MenuButton nameMenu;
    @FXML
    private Label labelDay;

    @FXML
    private Label labelEnd;

    @FXML
    private Label labelMonth;

    @FXML
    private Label labelPeriod;

    @FXML
    private Label labelStart;

    @FXML
    private Label labelYear;


    @FXML
    void initialize() {
            nameMenu.setText("Разница между датами");

    }

    @FXML
    void calculateDate(ActionEvent event) {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (startDate != null && endDate != null) {
            boolean isStartDateBeforeEndDate = startDate.isBefore(endDate);
            Period period;
            if (isStartDateBeforeEndDate) {
                period = Period.between(startDate, endDate);
            } else {
                period = Period.between(endDate, startDate);
            }

            int years = period.getYears();
            int months = period.getMonths();
            int days = period.getDays();

            outputYear.setText(Integer.toString(years));
            outputMonth.setText(Integer.toString(months));
            outputDay.setText(Integer.toString(days));
        } else {
            outputYear.setText("");
            outputMonth.setText("");
            outputDay.setText("");
        }
    }

    @FXML
    void typeCalcDate(ActionEvent event) {
        String s = ((MenuItem) event.getSource()).getText();
        if (differenceBetweenDates == event.getSource()) {
            setTypeCalcScene("/com/example/calculator/DifferenceDateCalc.fxml");
        } else if (plusOrMinusDate == event.getSource()){
            setTypeCalcScene("/com/example/calculator/PlusAndMinusDateCalc.fxml");
        }
    }

    private void setTypeCalcScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) getWindow().getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void style(ActionEvent event) {
        String backgroundColor;
        String textColor;
        String labelColor;

        if (getWindow().getStyle().equals("-fx-background-color: #111111;")) {
            backgroundColor = "white";
            textColor = "#111111";
            labelColor = "F29611";
        } else {
            backgroundColor = "#111111";
            textColor = "white";
            labelColor = " #3E3E3E";
        }

        labelDay.setStyle("-fx-text-fill: " + textColor + ";");
        labelMonth.setStyle("-fx-text-fill: " + textColor + ";");
        labelYear.setStyle("-fx-text-fill: " + textColor + ";");
        labelStart.setStyle("-fx-text-fill: " + textColor + ";");
        labelEnd.setStyle("-fx-text-fill: " + textColor + ";");
        labelPeriod.setStyle("-fx-text-fill: " + textColor + ";");
        getWindow().setStyle("-fx-background-color: " + backgroundColor + ";");
        getColorStyle().setStyle("-fx-background-color: " + textColor + "; -fx-text-fill: " + backgroundColor + "; -fx-background-radius: 50");
        outputDay.setStyle("-fx-text-fill: " + textColor + "; -fx-background-color: " + labelColor  + "; -fx-background-radius: 10");
        outputMonth.setStyle("-fx-text-fill: " + textColor + "; -fx-background-color: " + labelColor + "; -fx-background-radius: 10");
        outputYear.setStyle("-fx-text-fill: " + textColor + "; -fx-background-color: " + labelColor + "; -fx-background-radius: 10");
    }

    public DatePicker getStartDatePicker() {
        return startDatePicker;
    }

    public Label getOutputDay() {
        return outputDay;
    }

    public Label getOutputMonth() {
        return outputMonth;
    }

    public Label getOutputYear() {
        return outputYear;
    }

    public MenuItem getDifferenceBetweenDates() {
        return differenceBetweenDates;
    }

    public MenuItem getPlusOrMinusDate() {
        return plusOrMinusDate;
    }

    public MenuButton getNameMenu() {
        return nameMenu;
    }

    public Label getLabelStart() {
        return labelStart;
    }
}
