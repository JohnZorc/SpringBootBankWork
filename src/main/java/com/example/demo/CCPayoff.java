package com.example.demo;

import java.text.DecimalFormat;

public class CCPayoff {
	
	/*
	 * Inputs:
	 * -CC balance
	 * -CC interest rate
	 * -desired months to payoff
	 */
	
	/*
	 * Outputs:
	 * -monthly payment
	 * -total principle paid
	 * -total interest paid
	 */

	public static String printPayOff(double ccBalance, double ccInterest, int months) {
		String response="";
		String[] split = ((Double)ccBalance).toString().split("\\.");
		
		if(ccBalance<=0||ccInterest<0||months<=0||split[1].length()>2) {
			response="Invalid inputs, please try again.";
		}else {;
			double totalInterest = calcInterest(ccBalance,ccInterest);
			DecimalFormat df = new DecimalFormat("0.##");
			
			response="Your monthly payment: $"+calcMonthlyPayment(ccBalance,totalInterest,months)+
					"\nThe total principle: $"+df.format(ccBalance)+
					"\nThe total interest: $"+df.format(totalInterest)+"\n\n";
		}
		return response;

	}
	
	public static double calcMonthlyPayment(double totalPrinciple, double totalInterest, int months) {
		//format to have 2 dec points
		DecimalFormat df = new DecimalFormat("0.##");
		String result=df.format((totalPrinciple+totalInterest)/months);
		return Double.parseDouble(result);
	}
	
	public static double calcInterest(double ccBalance, double ccInterest) {
		return ccBalance*(ccInterest/100);
	}

}
