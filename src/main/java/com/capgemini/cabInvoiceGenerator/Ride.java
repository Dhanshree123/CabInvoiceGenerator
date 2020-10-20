package com.capgemini.cabInvoiceGenerator;

public class Ride {

	public CabRide cabRide;
	public double distance;
	public int time;

	public Ride(double distance, int time, CabRide cabRide) {
		this.distance = distance;
		this.time = time;
		this.cabRide = cabRide;
	}

}
