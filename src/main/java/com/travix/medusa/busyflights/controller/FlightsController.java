package com.travix.medusa.busyflights.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.FlightService;

@RestController
public class FlightsController {

	private final FlightService flightsService;

	public FlightsController(FlightService flightsService) {
		this.flightsService = flightsService;
	}

	@GetMapping("/flights/{origin}/{destination}")
	public List<BusyFlightsResponse> flights(@PathVariable(value = "origin") String origin, @PathVariable(value = "destination") String destination,
			@RequestParam(value = "departureDate") String departureDate, @RequestParam(value = "returnDate", required = false) String returnDate,
			@RequestParam(value = "passengers") int passengers) throws InterruptedException {

		return flightsService.findAllFlights(origin, destination, departureDate, returnDate, passengers);
	}
}
