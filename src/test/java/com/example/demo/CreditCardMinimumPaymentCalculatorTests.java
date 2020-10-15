package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditCardMinimumPaymentCalculatorTests
{
    @Test
    public void testAllValidOutputs() {
        assertEquals(112.50, CreditCardMinimumPaymentCalculator.CreditCardMinimumPaymentCalculator(75, 1, 3),
                "Tests for valid outputs and output formatting");
    }

    @Test
    public void testInvalidCCBalance() {
        assertEquals(-1, CreditCardMinimumPaymentCalculator.CreditCardMinimumPaymentCalculator(0, 10, 3),
                "Tests invalid non-positive CCBalance");
    }

    @Test
    public void testInvalidCCInterestRate() {
        assertEquals(-1, CreditCardMinimumPaymentCalculator.CreditCardMinimumPaymentCalculator(1000, -10, 3),
                "Tests invalid non-positive CCInterestRate");
    }

    @Test
    public void testInvalidMinPaymentPercentage() {
        assertEquals(-1, CreditCardMinimumPaymentCalculator.CreditCardMinimumPaymentCalculator(1000, 10, -1),
                "Tests invalid non-positive Minimum Payment Percentage");
    }

    @Test
    public void testMinimumPaymentTooLow() {
        //If the Minimum Payment is too low, the balance would never be paid off
        assertEquals(-1, CreditCardMinimumPaymentCalculator.CreditCardMinimumPaymentCalculator(10, 10, 2),
                "Tests if it is possible to pay off the debt with the current minimum payment");
    }
}
