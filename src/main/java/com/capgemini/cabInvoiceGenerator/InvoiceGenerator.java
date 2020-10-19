package com.capgemini.cabInvoiceGenerator;

public class InvoiceGenerator {

	public static final double COST_PER_KM = 10;
	public static final int COST_PER_TIME = 1;

	public double calculateFare(double distance, int time) {
		return distance * COST_PER_KM + time * COST_PER_TIME;

	}

}
