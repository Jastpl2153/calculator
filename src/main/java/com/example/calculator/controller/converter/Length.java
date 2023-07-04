package com.example.calculator.controller.converter;

public class Length extends SkilletConverter{
    @Override
    protected double getConversionFactor(String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "Дециметр":
                switch (toUnit) {
                    case "Дециметр": return 1.0;
                    case "Миллиметр": return 100;
                    case "Километр": return 0.0001;
                    case "Сантиметр": return 10;
                    case "Метр": return 0.1;
                    case "Микрометр": return 100000;
                }
                break;
            case "Миллиметр":
                switch (toUnit) {
                    case "Дециметр": return 0.01;
                    case "Миллиметр": return 1.0;
                    case "Километр": return 0.000001;
                    case "Сантиметр": return 0.1;
                    case "Метр": return 0.001;
                    case "Микрометр": return 1000;
                }
                break;
            case "Километр":
                switch (toUnit) {
                    case "Дециметр": return 10000;
                    case "Миллиметр": return 1000000;
                    case "Километр": return 1.0;
                    case "Сантиметр": return 100000;
                    case "Метр": return 1000;
                    case "Микрометр": return 1000000000;
                }
                break;
            case "Сантиметр":
                switch (toUnit) {
                    case "Дециметр": return 0.1;
                    case "Миллиметр": return 10;
                    case "Километр": return 0.00001;
                    case "Сантиметр": return 1.0;
                    case "Метр": return 0.01;
                    case "Микрометр": return 10000;
                }
                break;
            case "Метр":
                switch (toUnit) {
                    case "Дециметр": return 10;
                    case "Миллиметр": return 1000;
                    case "Километр": return 0.001;
                    case "Сантиметр": return 100;
                    case "Метр": return 1.0;
                    case "Микрометр": return 1000000;
                }
                break;
            case "Микрометр":
                switch (toUnit) {
                    case "Дециметр": return 0.00001;
                    case "Миллиметр": return 0.001;
                    case "Километр": return 0.000000001;
                    case "Сантиметр": return 0.0001;
                    case "Метр": return 0.000001;
                    case "Микрометр": return 1.0;
                }
                break;
        }
        return 0.0;
    }
}
