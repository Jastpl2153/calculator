package com.example.calculator.controller;

import javafx.event.ActionEvent;

public class ConverterController extends UsualController {
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

            getWindow().setStyle("-fx-background-color: " + backgroundColor + ";");
            getColorStyle().setStyle("-fx-background-color: " + textColor + "; -fx-text-fill: " + backgroundColor + "; -fx-background-radius: 50");
    }
}
