package com.capgemini.cabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

	InvoiceService invoiceService = null;

	@Before
	public void CreateObject() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTimeShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnTotalFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, invoiceSummary);
	}

	@Test
	public void givenUserIdAndRidesShouldReturnInvoiceSummary() {
		String userId = "abc@gmail.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, invoiceSummary);
	}

}
