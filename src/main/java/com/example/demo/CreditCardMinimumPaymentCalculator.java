package com.example.demo;

import java.text.DecimalFormat;

public class CreditCardMinimumPaymentCalculator
{

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static double CreditCardMinimumPaymentCalculator(double CCBalance, double CCInterestRate, double minimumPaymentPercentage)
    {
        if ( CCBalance <= 0.0 || CCInterestRate <= 0.0 || minimumPaymentPercentage <= 0.0)
        {
            System.out.println("Invalid input, please input only positive numbers.");
            return -1;
        }

        double monthlyPayment = CCBalance*(minimumPaymentPercentage/100.0);
        int months = 0;
        double total = CCBalance;
        double paid = total;

        if (monthlyPayment <= total*(CCInterestRate/100.0))
        {
            System.out.println("Payment cannot be completed; minimumPaymentPercentage is too low");
            return -1;
        }

        while( total > 0.0)
        {
            total = total + CCBalance*(CCInterestRate/100.0) - monthlyPayment;
            paid = paid + CCBalance*(CCInterestRate/100.0);
            months++;
        }

        System.out.println("Monthly Payment: " + df.format(monthlyPayment));
        System.out.println("# of Months to Pay Off Balance: " + months);
        System.out.println("Total $ Amount Paid: " + df.format(paid));
        return Double.parseDouble(df.format(paid));

    }
}
