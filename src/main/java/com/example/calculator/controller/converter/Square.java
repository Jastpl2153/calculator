package com.example.calculator.controller.converter;

public class Square extends SkilletConverter{
    @Override
    protected double getConversionFactor(String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "Квадратный метр":
                switch (toUnit) {
                    case "Квадратный метр": return 1;
                    case "Квадратный дециметр": return 100;
                    case "Квадратный сантиметр": return 10000;
                    case "Квадратный километр": return 0.000001;
                    case "Квадратный миллиметр": return 1000000;
                    case "Гектар": return 0.0001;
                }
                break;
            case "Квадратный дециметр":
                switch (toUnit) {
                    case "Квадратный метр": return 0.01;
                    case "Квадратный дециметр": return 1;
                    case "Квадратный сантиметр": return 100;
                    case "Квадратный километр": return 1E-8;
                    case "Квадратный миллиметр": return 10000;
                    case "Гектар": return 0.000001;
                }
                break;
            case "Квадратный сантиметр":
                switch (toUnit) {
                    case "Квадратный метр": return 0.0001;
                    case "Квадратный дециметр": return 0.01;
                    case "Квадратный сантиметр": return 1;
                    case "Квадратный километр": return 1E-10;
                    case "Квадратный миллиметр": return 100;
                    case "Гектар": return 1E-8;
                }
                break;
            case "Квадратный километр":
                switch (toUnit) {
                    case "Квадратный метр": return 1000000;
                    case "Квадратный дециметр": return 100_000_000;
                    case "Квадратный сантиметр": return 1E10;
                    case "Квадратный километр": return 1;
                    case "Квадратный миллиметр": return 1E12;
                    case "Гектар": return 100;
                }
                break;
            case "Квадратный миллиметр":
                switch (toUnit) {
                    case "Квадратный метр": return 0.000001;
                    case "Квадратный дециметр": return 0.0001;
                    case "Квадратный сантиметр": return 0.01;
                    case "Квадратный километр": return 1E-12;
                    case "Квадратный миллиметр": return 1;
                    case "Гектар": return 1E-10;
                }
                break;
            case "Гектар":
                switch (toUnit) {
                    case "Квадратный метр": return 10000;
                    case "Квадратный дециметр": return 1000000;
                    case "Квадратный сантиметр": return 100000000;
                    case "Квадратный километр": return 0.01;
                    case "Квадратный миллиметр": return 1E10;
                    case "Гектар": return 1;
                }
                break;
        }
        return 0.0;
    }
}
