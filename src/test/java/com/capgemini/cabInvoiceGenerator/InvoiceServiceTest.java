package com.capgemini.cabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

	InvoiceService invoiceService = null;
	RideRepository rideRepository = null;
	Ride[] rides;
	InvoiceSummary expectedSummary = null;

	@Before
	public void CreateObject() {
		invoiceService = new InvoiceService();
		rideRepository = new RideRepository();
		invoiceService.setRideRepository(rideRepository);
		rides = new Ride[] { new Ride(2.0, 5, CabRide.NORMAL), new Ride(0.1, 1, CabRide.PREMIUM),

		};
		expectedSummary = new InvoiceSummary(2, 45.0);
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
		InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
		Assert.assertEquals(expectedSummary, invoiceSummary);
	}

	@Test
	public void givenUserIdAndRidesShouldReturnInvoiceSummary() {
		String userId = "abc@gmail.com";
		invoiceService.addRides(userId, rides);
		InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
		Assert.assertEquals(expectedSummary, invoiceSummary);
	}

}
