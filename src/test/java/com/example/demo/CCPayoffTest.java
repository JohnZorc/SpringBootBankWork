package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CCPayoffTest {

	@Test
	//test correct input for months, interest rate, and cc balance
	//test correct format (2 decimal points)
	//test correct exception pops up
	void testPrintPayOff() {
		assertEquals("Invalid inputs, please try again.", CCPayoff.printPayOff(-234.45, 10, 8), "A negative credit card balance input will return an error message.");
		assertEquals("Invalid inputs, please try again.", CCPayoff.printPayOff(234.45, -10, 8), "A negative interest input will return an error message.");
		assertEquals("Invalid inputs, please try again.", CCPayoff.printPayOff(234.45, 10, -8), "A negative month input will return an error message.");
		assertEquals("Invalid inputs, please try again.", CCPayoff.printPayOff(234.454, 10, 8), "A input of credit card balance that doesn't have standard $.## format will return an error message.");
		
		assertEquals("Invalid inputs, please try again.", CCPayoff.printPayOff(234.45, 10, 0), "A 0 month input will return an error message.");
		assertEquals("Invalid inputs, please try again.", CCPayoff.printPayOff(0, 10, 8), "A 0 credit card balance input will return an error message.");
	    
		assertEquals("Your monthly payment: $32.24\nThe total principle: $234.45\nThe total interest: $23.45\n\n", CCPayoff.printPayOff(234.45, 10, 8), "Total principle and interest paid should be formatted to 2 decimal points.");

	}

	@Test
	//test correct calculation
	//test correct format
	void testCalcMonthlyPayment() {
		assertEquals(30.56, CCPayoff.calcMonthlyPayment(234.45, 10,8), "Calculation should be correct and formatted to 2 decimal points.");
	}

	@Test
	//test correct calculation
	void testCalcInterest() {
		assertEquals(35.1675, CCPayoff.calcInterest(234.45, 15), "Calculation should be correct.");
	}

}
