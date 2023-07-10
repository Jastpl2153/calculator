package com.example.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Controller for selecting the converter type
 */

public class ConverterController extends UsualController {
    @FXML
    void handleTypeConverter(ActionEvent event) {
        String converter = ((Button) event.getSource()).getText();
        switch (converter) {
            case " \uD83D\uDCCF  Длина" -> {
                setTypeCalcScene("/com/example/calculator/converter/sceneConverterLength.fxml", 298, 537);
            }
            case "⛶ Площаль" -> {
                setTypeCalcScene("/com/example/calculator/converter/sceneConverterSquare.fxml", 298, 537);
            }
            case " ㎏  Масса" -> {
                setTypeCalcScene("/com/example/calculator/converter/sceneConverterWeight.fxml", 298, 537);
            }
            case "℃ Тем-ра" -> {
                setTypeCalcScene("/com/example/calculator/converter/sceneConverterTemperature.fxml", 298, 537);
            }
            case "㎧ Скорость" -> {
                setTypeCalcScene("/com/example/calculator/converter/sceneConverterSpeed.fxml", 298, 537);
            }
            case "㍴ Давление" -> {
                setTypeCalcScene("/com/example/calculator/converter/sceneConverterPressure.fxml", 298, 537);
            }
            case "㎺ Мощность" -> {
                setTypeCalcScene("/com/example/calculator/converter/sceneConverterPower.fxml", 298, 537);
            }
            case "㎦  Объем" -> {
                setTypeCalcScene("/com/example/calculator/converter/sceneConverterVolume.fxml", 298, 537);
            }
        }
    }

    @FXML
    void handleBack(ActionEvent event) {
        try {
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                    ("/com/example/calculator/ConverterCalc.fxml")));
            Scene scene = new Scene(newRoot);
            Stage stage = (Stage) getWindow().getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Подумать об отдельном классе.
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
