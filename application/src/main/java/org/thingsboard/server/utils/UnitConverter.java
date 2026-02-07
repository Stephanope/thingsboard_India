/**
 * Copyright © 2016-2026 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class UnitConverter {

    // --- Température ---
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    // --- Longueur ---
    public static double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static double metersToFeet(double meters) {
        return meters / 0.3048;
    }

    // --- Poids ---
    public static double kilogramsToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double poundsToKilograms(double lbs) {
        return lbs / 2.20462;
    }

    // --- Vitesse ---
    public static double kmhToMph(double kmh) {
        return kmh * 0.621371;
    }

    public static double mphToKmh(double mph) {
        return mph / 0.621371;
    }

    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}