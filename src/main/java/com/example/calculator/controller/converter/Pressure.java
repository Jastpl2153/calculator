package com.example.calculator.controller.converter;

public class Pressure extends SkilletConverter {
    @Override
    protected double getConversionFactor(String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "Бар":
                switch (toUnit) {
                    case "Бар":
                        return 1.0;
                    case "Миллибар":
                        return 1000;
                    case "Килопаскаль":
                        return 100;
                    case "Гектопаскаль":
                        return 1000;
                    case "Стандартная физическая атмосфера":
                        return 0.986923;
                    case "Килограмм-сила на квадратный метр":
                        return 10197.1621;
                    case "Мегапаскаль":
                        return 0.1;
                }
                break;
            case "Миллибар":
                switch (toUnit) {
                    case "Бар":
                        return 0.001;
                    case "Миллибар":
                        return 1.0;
                    case "Килопаскаль":
                        return 0.1;
                    case "Гектопаскаль":
                        return 1.0;
                    case "Стандартная физическая атмосфера":
                        return 0.000986923;
                    case "Килограмм-сила на квадратный метр":
                        return 10.1971621;
                    case "Мегапаскаль":
                        return 0.0001;
                }
                break;
            case "Килопаскаль":
                switch (toUnit) {
                    case "Бар":
                        return 0.01;
                    case "Миллибар":
                        return  10;
                    case "Килопаскаль":
                        return 1.0;
                    case "Гектопаскаль":
                        return 10.0;
                    case "Стандартная физическая атмосфера":
                        return 0.00986923;
                    case "Килограмм-сила на квадратный метр":
                        return 101.971621;
                    case "Мегапаскаль":
                        return 0.001;
                }
                break;
            case "Гектопаскаль":
                switch (toUnit) {
                    case "Бар":
                        return 0.001;
                    case "Миллибар":
                        return 1.0;
                    case "Килопаскаль":
                        return  0.1;
                    case "Гектопаскаль":
                        return 1.0;
                    case "Стандартная физическая атмосфера":
                        return 0.000986923;
                    case "Килограмм-сила на квадратный метр":
                        return 10.1971621;
                    case "Мегапаскаль":
                        return 0.0001;
                }
                break;
            case "Стандартная физическая атмосфера":
                switch (toUnit) {
                    case "Бар":
                        return 1.01325;
                    case "Миллибар":
                        return 1013.25;
                    case "Килопаскаль":
                        return 101.325;
                    case "Гектопаскаль":
                        return 1013.250273830886503;
                    case "Стандартная физическая атмосфера":
                        return 1.0;
                    case "Килограмм-сила на квадратный метр":
                        return 10332.3;
                    case "Мегапаскаль":
                        return 0.101325;
                }
                break;
            case "Килограмм-сила на квадратный метр":
                switch (toUnit) {
                    case "Бар":
                        return 0.000098066500286389;
                    case "Миллибар":
                        return 0.098066500286389;
                    case "Килопаскаль":
                        return 0.0098066500286389;
                    case "Гектопаскаль":
                        return 0.098066500286389;
                    case "Стандартная физическая атмосфера":
                        return 0.0000967840846621;
                    case "Килограмм-сила на квадратный метр":
                        return 1.0;
                    case "Мегапаскаль":
                        return 0.0000098066500286389;
                }
                break;
            case "Мегапаскаль":
                switch (toUnit) {
                    case "Бар":
                        return 1.0;
                    case "Миллибар":
                        return 10000;
                    case "Килопаскаль":
                        return 1000;
                    case "Гектопаскаль":
                        return 100000;
                    case "Стандартная физическая атмосфера":
                        return 9.86923;
                    case "Килограмм-сила на квадратный метр":
                        return 101971.621;
                    case "Мегапаскаль":
                        return 1.0;
                }
                break;
        }
        return 0.0;
    }
}
