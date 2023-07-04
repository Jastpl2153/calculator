module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.calculator to javafx.fxml;
    exports com.example.calculator;
    opens com.example.calculator.controller to javafx.fxml;

    exports com.example.calculator.controller;
    exports com.example.calculator.controller.converter;
    opens com.example.calculator.controller.converter to javafx.fxml;
}