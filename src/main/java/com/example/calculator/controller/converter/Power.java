package com.example.calculator.controller.converter;

public class Power extends SkilletConverter {
    @Override
    protected double getConversionFactor(String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "Ватт":
                switch (toUnit) {
                    case "Ватт":
                        return 1.0;
                    case "Киловатт":
                        return 0.001;
                    case "Джоуль в секунду":
                        return 1.0;
                    case "Килокалория в секунду":
                        return 0.0002388459;
                    case "Футо-фунт в секунду":
                        return 0.7375621493;
                    case "Ньютон метр в секунду":
                        return 1.0;
                }
                break;
            case "Киловатт":
                switch (toUnit) {
                    case "Ватт":
                        return 1000.0;
                    case "Киловатт":
                        return 1.0;
                    case "Джоуль в секунду":
                        return 1000.0;
                    case "Килокалория в секунду":
                        return 0.2388458966;
                    case "Футо-фунт в секунду":
                        return 737.5621492773;
                    case "Ньютон метр в секунду":
                        return 1000.0;
                }
                break;
            case "Джоуль в секунду":
                switch (toUnit) {
                    case "Ватт":
                        return 1.0;
                    case "Киловатт":
                        return 0.001;
                    case "Джоуль в секунду":
                        return 1.0;
                    case "Килокалория в секунду":
                        return 0.0002388459;
                    case "Футо-фунт в секунду":
                        return 0.7375621493;
                    case "Ньютон метр в секунду":
                        return 1.0;
                }
                break;
            case "Килокалория в секунду":
                switch (toUnit) {
                    case "Ватт":
                        return 4184.1;
                    case "Киловатт":
                        return 4.184;
                    case "Джоуль в секунду":
                        return 4184.0;
                    case "Килокалория в секунду":
                        return 1.0;
                    case "Футо-фунт в секунду":
                        return 3086.7969243158;
                    case "Ньютон метр в секунду":
                        return 4.184;
                }
                break;
            case "Футо-фунт в секунду":
                switch (toUnit) {
                    case "Ватт":
                        return 1.3558179483;
                    case "Киловатт":
                        return 0.0013558179;
                    case "Джоуль в секунду":
                        return 1.3558179483;
                    case "Килокалория в секунду":
                        return 0.0003240404898;
                    case "Футо-фунт в секунду":
                        return 1.0;
                    case "Ньютон метр в секунду":
                        return 1.355817949;
                }
                break;
            case "Ньютон метр в секунду":
                switch (toUnit) {
                    case "Ватт":
                        return 1.0;
                    case "Киловатт":
                        return 0.001;
                    case "Джоуль в секунду":
                        return 1.0;
                    case "Килокалория в секунду":
                        return 0.000239;
                    case "Футо-фунт в секунду":
                        return 0.7375621489;
                    case "Ньютон метр в секунду":
                        return 1.0;
                }
                break;
        }
        return 0.0;
    }
}

