package com.example.calculator.controller.converter;

public class Temperature extends SkilletConverter {
    @Override
    protected void converter() {
        if (!getOutput().getText().isEmpty()) {
            double convertedValue = getConversionFactor(getType().getText(), getType2().getText());
            getResult().setText(String.valueOf(convertedValue));
        }
    }

    @Override
    protected double getConversionFactor(String fromUnit, String toUnit) {
        double fromNum = Double.parseDouble(getOutput().getText());
        switch (fromUnit) {
            case "Градус Ранкина":
                switch (toUnit) {
                    case "Градус Цельсия":
                        return (fromNum - 491.67) * 5 / 9;
                    case "Градус Реомюра":
                        return (fromNum - 491.67) * 4 / 9;
                    case "Градус Фаренгейта":
                        return fromNum - 459.67;
                    case "Кельвин":
                        return fromNum * 5 / 9;
                }
                break;
            case "Градус Цельсия":
                switch (toUnit) {
                    case "Градус Ранкина":
                        return fromNum * 9 / 5 + 491.67;
                    case "Градус Реомюра":
                        return fromNum * 4 / 5;
                    case "Градус Фаренгейта":
                        return fromNum * 9 / 5 + 32;
                    case "Кельвин":
                        return fromNum + 273.15;
                }
                break;
            case "Градус Реомюра":
                switch (toUnit) {
                    case "Градус Ранкина":
                        return fromNum * 2.25 + 491.67;
                    case "Градус Цельсия":
                        return fromNum * 5 / 4;
                    case "Градус Фаренгейта":
                        return fromNum * 9 / 4 + 32;
                    case "Кельвин":
                        return fromNum * 5 / 4 + 273.15;
                }
                break;
            case "Градус Фаренгейта":
                switch (toUnit) {
                    case "Градус Ранкина":
                        return fromNum + 459.67;
                    case "Градус Цельсия":
                        return (fromNum - 32) * 5 / 9;
                    case "Градус Реомюра":
                        return (fromNum - 32) * 4 / 9;
                    case "Кельвин":
                        return (fromNum + 459.67) * 5 / 9;
                }
                break;
            case "Кельвин":
                switch (toUnit) {
                    case "Градус Ранкина":
                        return fromNum * 9 / 5;
                    case "Градус Цельсия":
                        return fromNum - 273.15;
                    case "Градус Реомюра":
                        return (fromNum - 273.15) * 4 / 5;
                    case "Градус Фаренгейта":
                        return fromNum * 9 / 5 - 459.67;
                }
                break;
        }
        return 0.0;
    }
}

