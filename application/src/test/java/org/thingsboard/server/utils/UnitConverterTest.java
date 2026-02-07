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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitConverterTest {

    private static final double DELTA = 0.001; 

    @Test
    public void testTemperatureConversions() {
        // Test C -> F
        Assertions.assertEquals(32.0, UnitConverter.celsiusToFahrenheit(0), DELTA);
        Assertions.assertEquals(212.0, UnitConverter.celsiusToFahrenheit(100), DELTA);
        Assertions.assertEquals(-40.0, UnitConverter.celsiusToFahrenheit(-40), DELTA);

        // Test F -> C
        Assertions.assertEquals(0.0, UnitConverter.fahrenheitToCelsius(32), DELTA);
        Assertions.assertEquals(100.0, UnitConverter.fahrenheitToCelsius(212), DELTA);
    }

    @Test
    public void testLengthConversions() {
        // Test Ft -> M
        Assertions.assertEquals(0.3048, UnitConverter.feetToMeters(1), DELTA);
        Assertions.assertEquals(3.048, UnitConverter.feetToMeters(10), DELTA);

        // Test M -> Ft
        Assertions.assertEquals(1.0, UnitConverter.metersToFeet(0.3048), DELTA);
        Assertions.assertEquals(3.28084, UnitConverter.metersToFeet(1), DELTA);
    }

    @Test
    public void testWeightConversions() {
        // Test Kg -> Lbs
        Assertions.assertEquals(2.20462, UnitConverter.kilogramsToPounds(1), DELTA);
        
        // Test Lbs -> Kg
        Assertions.assertEquals(1.0, UnitConverter.poundsToKilograms(2.20462), DELTA);
    }

    @Test
    public void testSpeedConversions() {
        // Test Km/h -> Mph
        Assertions.assertEquals(62.1371, UnitConverter.kmhToMph(100), DELTA);

        // Test Mph -> Km/h
        Assertions.assertEquals(100.0, UnitConverter.mphToKmh(62.1371), DELTA);
    }

    @Test
    public void testRounding() {
        double val = 123.456789;
        Assertions.assertEquals(123.46, UnitConverter.round(val, 2), DELTA);
        Assertions.assertEquals(123.5, UnitConverter.round(val, 1), DELTA);
        Assertions.assertEquals(123.0, UnitConverter.round(val, 0), DELTA);
    }
}