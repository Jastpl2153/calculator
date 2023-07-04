package com.example.calculator.controller.converter;

public class Weight extends SkilletConverter{
    @Override
    protected double getConversionFactor(String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "Грамм":
                switch (toUnit) {
                    case "Грамм": return 1;
                    case "Микрограмм": return 1000000;
                    case "Квинтал": return 0.00001;
                    case "Карат": return 5;
                    case "Тонна": return 0.000001;
                    case "Миллиграмм": return 1000;
                    case "Килограмм": return 0.001;
                }
                break;
            case "Микрограмм":
                switch (toUnit) {
                    case "Грамм": return 0.000001;
                    case "Микрограмм": return 1;
                    case "Квинтал": return 1.E-11;
                    case "Карат": return 0.000005;
                    case "Тонна": return 1E-12;
                    case "Миллиграмм": return 0.001;
                    case "Килограмм": return 1E-9;
                }
                break;
            case "Квинтал":
                switch (toUnit) {
                    case "Грамм": return 100000;
                    case "Микрограмм": return 1E11;
                    case "Квинтал": return 1;
                    case "Карат": return 500000;
                    case "Тонна": return 0.1;
                    case "Миллиграмм": return 100000000;
                    case "Килограмм": return 100;
                }
                break;
            case "Карат":
                switch (toUnit) {
                    case "Грамм": return 0.2;
                    case "Микрограмм": return 200000;
                    case "Квинтал": return 0.000002;
                    case "Карат": return 1;
                    case "Тонна": return 2E-7;
                    case "Миллиграмм": return 200;
                    case "Килограмм": return 0.0002;
                }
                break;
            case "Тонна":
                switch (toUnit) {
                    case "Грамм": return 1000000;
                    case "Микрограмм": return 1E12;
                    case "Квинтал": return 10;
                    case "Карат": return 5000000;
                    case "Тонна": return 1;
                    case "Миллиграмм": return 1E9;
                    case "Килограмм": return 1000;
                }
                break;
            case "Миллиграмм":
                switch (toUnit) {
                    case "Грамм": return 0.001;
                    case "Микрограмм": return 1000;
                    case "Квинтал": return 1E-8;
                    case "Карат": return 0.005;
                    case "Тонна": return 1E-9;
                    case "Миллиграмм": return 1;
                    case "Килограмм": return 0.000001;
                }
                break;
            case "Килограмм":
                switch (toUnit) {
                    case "Грамм": return 1000;
                    case "Микрограмм": return 1E9;
                    case "Квинтал": return 0.01;
                    case "Карат": return 5000;
                    case "Тонна": return 0.001;
                    case "Миллиграмм": return 1000000;
                    case "Килограмм": return 1;
                }
                break;
        }
        return 0.0;
    }
}
