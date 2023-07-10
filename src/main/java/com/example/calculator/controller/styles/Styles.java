package com.example.calculator.controller.styles;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

public class Styles {
    public static final String COLOR_BLACK = "#111111";
    public static final String COLOR_WHITE = "white";
    public static final String COLOR_ORANGE = "F29611";
    public static final String COLOR_GRAY = "ACACAC";
    public static final String COLOR_DARK_GRAY = "#3E3E3E";
    public static final String RADIUS_CIRCLE = "50";
    public static final String OPACITY = "1";

    // Styles for UsualCalc
    public static void applyDarkStyle(VBox window, Node colorStyle, Label output, Label info) {
        window.setStyle("-fx-background-color: " + COLOR_BLACK + ";");
        colorStyle.setStyle("-fx-background-color: " + COLOR_WHITE
                + "; -fx-text-fill: " + COLOR_BLACK
                + "; -fx-background-radius: " + RADIUS_CIRCLE + ";");
        output.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
        info.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
    }

    public static void applyLightStyle(VBox window, Node colorStyle, Label output, Label info) {
        window.setStyle("-fx-background-color: " + COLOR_WHITE + ";");
        colorStyle.setStyle("-fx-background-color: " + COLOR_BLACK
                + "; -fx-text-fill:" + COLOR_WHITE
                + "; -fx-background-radius: " + RADIUS_CIRCLE + ";");
        output.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
        info.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
    }

    // Styles for AdvancedCalc
    public static void applyRadStyle(Button rad, Button deg) {
        rad.setStyle("-fx-background-color: #" + COLOR_ORANGE + "; -fx-background-radius: 30 30 0 0");
        deg.setStyle("-fx-background-color: #" + COLOR_GRAY + "; -fx-background-radius: 0 0 30 30");
    }

    public static void applyDegStyle(Button rad, Button deg) {
        rad.setStyle("-fx-background-color: #" + COLOR_GRAY + "; -fx-background-radius: 30 30 0 0");
        deg.setStyle("-fx-background-color: #" + COLOR_ORANGE + "; -fx-background-radius: 0 0 30 30");
    }

    // Styles for ConverterCalc
    public static void applyDarkStyle(VBox window, Node colorStyle) {
        window.setStyle("-fx-background-color: " + COLOR_BLACK + ";");
        colorStyle.setStyle("-fx-background-color: " + COLOR_WHITE
                + "; -fx-text-fill: " + COLOR_BLACK
                + "; -fx-background-radius: " + RADIUS_CIRCLE + ";");
    }

    public static void applyLightStyle(VBox window, Node colorStyle) {
        window.setStyle("-fx-background-color: " + COLOR_WHITE + ";");
        colorStyle.setStyle("-fx-background-color: " + COLOR_BLACK
                + "; -fx-text-fill: " + COLOR_WHITE
                + "; -fx-background-radius: " + RADIUS_CIRCLE + ";");
    }

    // Styles fot DifferenceDateController
    public static void applyDarkStyle(VBox window, Node colorStyle, Label outputDay, Label outputMonth, Label outputYear,
                                      Label labelDay, Label labelMonth, Label labelYear, Label labelStart, Label labelEnd,
                                      Label labelPeriod) {
        window.setStyle("-fx-background-color: " + COLOR_BLACK + ";");
        colorStyle.setStyle("-fx-background-color: " + COLOR_WHITE + "; -fx-text-fill: " + COLOR_BLACK + "; -fx-background-radius: 50");
        outputDay.setStyle("-fx-text-fill: " + COLOR_WHITE + "; -fx-background-color: " + COLOR_DARK_GRAY + "; -fx-background-radius: 10");
        outputMonth.setStyle("-fx-text-fill: " + COLOR_WHITE + "; -fx-background-color: " + COLOR_DARK_GRAY + "; -fx-background-radius: 10");
        outputYear.setStyle("-fx-text-fill: " + COLOR_WHITE + "; -fx-background-color: " + COLOR_DARK_GRAY + "; -fx-background-radius: 10");
        labelDay.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
        labelMonth.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
        labelYear.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
        labelStart.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
        labelEnd.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
        labelPeriod.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
    }

    public static void applyLightStyle(VBox window, Node colorStyle, Label outputDay, Label outputMonth, Label outputYear,
                                       Label labelDay, Label labelMonth, Label labelYear, Label labelStart, Label labelEnd,
                                       Label labelPeriod) {
        window.setStyle("-fx-background-color: " + COLOR_WHITE + ";");
        colorStyle.setStyle("-fx-background-color: " + COLOR_BLACK + "; -fx-text-fill: " + COLOR_WHITE + "; -fx-background-radius: 50");
        outputDay.setStyle("-fx-text-fill: " + COLOR_BLACK + "; -fx-background-color: " + COLOR_ORANGE + "; -fx-background-radius: 10");
        outputMonth.setStyle("-fx-text-fill: " + COLOR_BLACK + "; -fx-background-color: " + COLOR_ORANGE + "; -fx-background-radius: 10");
        outputYear.setStyle("-fx-text-fill: " + COLOR_BLACK + "; -fx-background-color: " + COLOR_ORANGE + "; -fx-background-radius: 10");
        labelDay.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
        labelMonth.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
        labelYear.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
        labelStart.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
        labelEnd.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
        labelPeriod.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
    }

    // Styles fot PlusAndMinusDateController
    public static void applyActiveStyle(ToggleButton button) {
        button.setStyle("-fx-background-color: " + COLOR_ORANGE
                + "; -fx-background-radius: 10; -fx-opacity: " + OPACITY + ";");
    }

    public static void applyInactiveStyle(ToggleButton button) {
        button.setStyle("-fx-background-color: " + COLOR_GRAY + "; -fx-background-radius: 10;");
    }

    public static void applyDarkStyle(VBox window, Node colorStyle, Label startDate, Label labelAdd, Label labelResult) {
        window.setStyle("-fx-background-color: " + COLOR_BLACK + ";");
        colorStyle.setStyle("-fx-background-color: " + COLOR_WHITE
                + "; -fx-text-fill: " + COLOR_BLACK
                + "; -fx-background-radius: " + RADIUS_CIRCLE + ";");
        startDate.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
        labelAdd.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");
        labelResult.setStyle("-fx-text-fill: " + COLOR_WHITE + ";");

    }

    public static void applyLightStyle(VBox window, Node colorStyle, Label startDate, Label labelAdd, Label labelResult) {
        window.setStyle("-fx-background-color: " + COLOR_WHITE + ";");
        colorStyle.setStyle("-fx-background-color: " + COLOR_BLACK
                + "; -fx-text-fill: " + COLOR_WHITE
                + "; -fx-background-radius: " + RADIUS_CIRCLE + ";");
        startDate.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
        labelAdd.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
        labelResult.setStyle("-fx-text-fill: " + COLOR_BLACK + ";");
    }
    // Styles fot NumberSystem
    public static void applyActiveStyleNumSys(ToggleButton button) {
        button.setStyle("-fx-background-color: " + COLOR_ORANGE
                + "; -fx-background-radius:  10 0 0 10; -fx-opacity: " + OPACITY + ";");
    }

    public static void applyInactiveStyleNumSys(ToggleButton button) {
        button.setStyle("-fx-background-color: " + COLOR_GRAY + "; -fx-background-radius:  10 0 0 10;");
    }
}
