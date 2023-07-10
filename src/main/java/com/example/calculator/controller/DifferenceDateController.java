package com.example.calculator.controller;

import com.example.calculator.controller.styles.Styles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.Period;

/**
 * Controller class for calculating the difference between dates
 */
public class DifferenceDateController extends UsualController  {
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Label outputDay;
    @FXML
    private Label outputMonth;
    @FXML
    private Label outputYear;

    @FXML
    private MenuButton nameMenu;
    @FXML
    private MenuItem differenceBetweenDates;
    @FXML
    private MenuItem plusOrMinusDate;

    @FXML
    private Label labelStart;
    @FXML
    private Label labelEnd;
    @FXML
    private Label labelPeriod;
    @FXML
    private Label labelDay;
    @FXML
    private Label labelMonth;
    @FXML
    private Label labelYear;

    @FXML
    void initialize() {
            nameMenu.setText("Разница между датами");
    }

    @FXML
    void handleTypeCalcDate(ActionEvent event) {
        if (differenceBetweenDates == event.getSource()) {
            setTypeCalcScene("/com/example/calculator/DifferenceDateCalc.fxml", 298, 537);
        } else if (plusOrMinusDate == event.getSource()){
            setTypeCalcScene("/com/example/calculator/PlusAndMinusDateCalc.fxml", 333, 629);
        }
    }

    @FXML
    void handleCalculateDate(ActionEvent event) {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (startDate != null && endDate != null) {
            Period period = startDate.isBefore(endDate)
                    ? Period.between(startDate, endDate)
                    : Period.between(endDate, startDate);

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

    @Override
    void style(ActionEvent event) {
        if (getWindow().getStyle().equals("-fx-background-color: " + Styles.COLOR_BLACK + ";")) {
            Styles.applyLightStyle(getWindow(), getColorStyle(), outputDay, outputMonth, outputYear,
                    labelDay, labelMonth, labelYear, labelStart, labelEnd, labelPeriod);
        } else {
            Styles.applyDarkStyle(getWindow(), getColorStyle(), outputDay, outputMonth, outputYear,
                    labelDay, labelMonth, labelYear, labelStart, labelEnd, labelPeriod);
        }
    }

    //getter and setter
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

    public MenuButton getNameMenu() {
        return nameMenu;
    }

    public Label getLabelStart() {
        return labelStart;
    }
}
