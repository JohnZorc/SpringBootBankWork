package com.example.demo;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageCalculator {

    // INPUTS:
    //  home price,
    //  down payment as a percentage (e.g., 15.5%),
    //  length of loan in years (whole number),
    //  interest rate


    // OUTPUTS:
    //  monthly payment,
    //  amount paid in interest,
    //  amount paid in principle,
    //  total amount paid


    public static int calculate(double homePrice, double downPaymentAsPercent, int loanLength, double interestRate) throws Exception {

        // Check inputs are valid
        if(homePrice <= 0){
            throw new Exception("User provided a non-positive and non-zero home price.");
        }

        if(downPaymentAsPercent <= 0){
            throw new Exception("User provided a non-positive and non-zero down payment percentage.");
        }

        if(loanLength <= 0){
            throw new Exception("User provided a non-positive and non-zero loan length.");
        }

        if(interestRate <= 0){
            throw new Exception("User provided a non-positive and non-zero interest rate.");
        }

        // Perform calculations
        double amountPaidInInterest = (interestRate / 100) * (homePrice);
        double amountPainInPrinciple = homePrice - ((downPaymentAsPercent / 100) * homePrice);
        double totalAmountPaid = amountPaidInInterest + amountPainInPrinciple;
        double monthlyPayment = totalAmountPaid / (12 * loanLength);

        // Format values to return them
        Locale locality = new Locale("en", "US");
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(locality);

        System.out.printf("Monthly Mortgage Payment: %s\n", numberFormatter.format(monthlyPayment));
        System.out.printf("Amount paid in principle: %s\n", numberFormatter.format(amountPainInPrinciple));
        System.out.printf("Amount paid in interest: %s\n", numberFormatter.format(amountPaidInInterest));
        System.out.printf("Total amount paid: %s\n", numberFormatter.format(totalAmountPaid));
        System.out.println();

        return 1;
    }




}
