package com.example.calculator.controller.converter;

public class Speed extends SkilletConverter{
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
            case "Скорость света":
                switch (toUnit) {
                    case "Скорость света":
                        return fromNum;
                    case "Километр в секунду":
                        return fromNum * 299792.458;
                    case "Миля в час":
                        return fromNum * 670616629.3843951;
                    case "Дюйм в секунду":
                        return fromNum * 1181102362.2047244;
                    case "Метр в секунду":
                        return fromNum * 299792458;
                    case "Километр в час":
                        return fromNum * 1079252848.8;
                }
                break;
            case "Километр в секунду":
                switch (toUnit) {
                    case "Скорость света":
                        return fromNum / 299792.458;
                    case "Километр в секунду":
                        return fromNum;
                    case "Миля в час":
                        return fromNum * 2236.9362920544;
                    case "Дюйм в секунду":
                        return fromNum * 39370.078740157;
                    case "Метр в секунду":
                        return fromNum * 1000;
                    case "Километр в час":
                        return fromNum * 3600;
                }
                break;
            case "Миля в час":
                switch (toUnit) {
                    case "Скорость света":
                        return fromNum / 670616629.3843951;
                    case "Километр в секунду":
                        return fromNum / 2236.9362920544;
                    case "Миля в час":
                        return fromNum;
                    case "Дюйм в секунду":
                        return fromNum * 17.6;
                    case "Метр в секунду":
                        return fromNum * 0.44704;
                    case "Километр в час":
                        return fromNum * 1.609344;
                }
                break;
            case "Дюйм в секунду":
                switch (toUnit) {
                    case "Скорость света":
                        return fromNum / 1181102362.2047244;
                    case "Километр в секунду":
                        return fromNum / 39370.078740157;
                    case "Миля в час":
                        return fromNum / 17.6;
                    case "Дюйм в секунду":
                        return fromNum;
                    case "Метр в секунду":
                        return fromNum * 0.0254;
                    case "Километр в час":
                        return fromNum * 0.09144;
                }
                break;
            case "Метр в секунду":
                switch (toUnit) {
                    case "Скорость света":
                        return fromNum / 299792458;
                    case "Километр в секунду":
                        return fromNum * 0.001;
                    case "Миля в час":
                        return fromNum * 2.2369362920544;
                    case "Дюйм в секунду":
                        return fromNum * 39.370078740157;
                    case "Метр в секунду":
                        return fromNum;
                    case "Километр в час":
                        return fromNum * 3.6;
                }
                break;
            case "Километр в час":
                switch (toUnit) {
                    case "Скорость света":
                        return fromNum / 1079252848.8;
                    case "Километр в секунду":
                        return fromNum / 3600;
                    case "Миля в час":
                        return fromNum * 0.62137119223733;
                    case "Дюйм в секунду":
                        return fromNum * 10.936132983377;
                    case "Метр в секунду":
                        return fromNum * 0.27777777777778;
                    case "Километр в час":
                        return fromNum;
                }
                break;
        }
        return 0.0;
    }
}
