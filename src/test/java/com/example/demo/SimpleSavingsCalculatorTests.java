package com.example.demo;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleSavingsCalculatorTests {
    //Tests
    @Test
    public void testSimpleSavingsCalculatorAllValidNonZero() {

        assertEquals(360.0, SimpleSavingsCalculator.SSCalculator(100, 10, 3, 10).get("TotalContributions"),
                "Tests all valid, non-zero numbers");
        assertEquals(102.0, SimpleSavingsCalculator.SSCalculator(100, 10, 3, 10).get("TotalInterestEarned"),
                "Tests all valid, non-zero numbers");
        assertEquals(562.0, SimpleSavingsCalculator.SSCalculator(100, 10, 3, 10).get("TotalSavings"),
                "Tests all valid, non-zero numbers");
    }
    @Test
    public void testSimpleSavingsCalculatorWithZeroPrinciple() {
        // 0, 10, 3,10
        assertEquals(360.0, SimpleSavingsCalculator.SSCalculator(0, 10, 3, 10).get("TotalContributions"),
                "Tests all valid, non-zero numbers");
        assertEquals(72.0, SimpleSavingsCalculator.SSCalculator(0, 10, 3, 10).get("TotalInterestEarned"),
                "Tests all valid, non-zero numbers");
        assertEquals(432.0, SimpleSavingsCalculator.SSCalculator(0, 10, 3, 10).get("TotalSavings"),
                "Tests all valid, non-zero numbers");
    }
    @Test
    public void testSimpleSavingsCalculatorNoGrowth() {
        //100, 0 ,3 ,10
        assertEquals(0.0, SimpleSavingsCalculator.SSCalculator(100, 0, 3, 10).get("TotalContributions"),
                "Tests all valid, non-zero numbers");
        assertEquals(30.0, SimpleSavingsCalculator.SSCalculator(100, 0, 3, 10).get("TotalInterestEarned"),
                "Tests all valid, non-zero numbers");
        assertEquals(130.0, SimpleSavingsCalculator.SSCalculator(100, 0, 3, 10).get("TotalSavings"),
                "Tests all valid, non-zero numbers");
    }
    @Test
    public void testSimpleSavingsCalculatorFractionalPeriods() {
        //100, 10, 3,5, 10
        //Use the decimal to multiple what wouldve been the whole years gain on interest by that fraction
        //Also calculate the amount added to contributions this way. Ex. If it was 3.7 years, for the last year the
        //total contributions would be (.7 * 12 * monthly contribution)
        assertEquals(420.0, SimpleSavingsCalculator.SSCalculator(100, 10, 3.5, 10).get("TotalContributions"),
                "Tests all valid, non-zero numbers");
        assertEquals(128.0, SimpleSavingsCalculator.SSCalculator(100, 10, 3.5, 10).get("TotalInterestEarned"),
                "Tests all valid, non-zero numbers");
        assertEquals(648.0, SimpleSavingsCalculator.SSCalculator(100, 10, 3.5, 10).get("TotalSavings"),
                "Tests all valid, non-zero numbers");
    }

    @Test
    public void testSimpleSavingsCalculatorInvalidInput() {
        assertEquals(null, SimpleSavingsCalculator.SSCalculator(-100, 10, 3.5, 10),
                "Tests SSCalc with an invalid input of -100 deposit");
    }
}
