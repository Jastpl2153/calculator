package com.example.calculator.controller.converter;

public class Volume extends SkilletConverter{
    protected double getConversionFactor(String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "Кубический метр":
                switch (toUnit) {
                    case "Кубический метр":
                        return 1.0;
                    case "Кубический сантиметр":
                        return 1_000_000.0;
                    case "Литр":
                        return 1000.0;
                    case "Миллилитр":
                        return 1_000_000.0;
                    case "Децилитр":
                        return 10_000.0;
                }
                break;
            case "Кубический сантиметр":
                switch (toUnit) {
                    case "Кубический метр":
                        return 0.000001;
                    case "Кубический сантиметр":
                        return 1.0;
                    case "Литр":
                        return 0.001;
                    case "Миллилитр":
                        return 1.0;
                    case "Децилитр":
                        return 0.01;
                }
                break;
            case "Литр":
                switch (toUnit) {
                    case "Кубический метр":
                        return 0.001;
                    case "Кубический сантиметр":
                        return 1000.0;
                    case "Литр":
                        return 1.0;
                    case "Миллилитр":
                        return 1000.0;
                    case "Децилитр":
                        return 10.0;

                }
                break;
            case "Миллилитр":
                switch (toUnit) {
                    case "Кубический метр":
                        return 0.000001;
                    case "Кубический сантиметр":
                        return 1.0;
                    case "Литр":
                        return 0.001;
                    case "Миллилитр":
                        return 1.0;
                    case "Децилитр":
                        return 0.01;
                }
                break;
            case "Децилитр":
                switch (toUnit) {
                    case "Кубический метр":
                        return 0.0001;
                    case "Кубический сантиметр":
                        return 100.0;
                    case "Литр":
                        return 0.1;
                    case "Миллилитр":
                        return 100.0;
                    case "Децилитр":
                        return 1.0;
                }
                break;
        }
        return 0.0;
    }
}
