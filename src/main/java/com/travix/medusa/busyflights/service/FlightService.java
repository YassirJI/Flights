package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface FlightService {

	List<BusyFlightsResponse> findAllFlights(String origin, String destination, String departureDate, String returnDate, int passengers)
			throws InterruptedException;

}