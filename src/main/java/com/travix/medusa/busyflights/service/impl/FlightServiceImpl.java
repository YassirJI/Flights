package com.travix.medusa.busyflights.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service.FlightService;
import com.travix.medusa.busyflights.service.rest.FlightClientService;
import com.travix.medusa.busyflights.utils.converter.CrazyAirFlightConverter;
import com.travix.medusa.busyflights.utils.converter.ToughFlightConverter;
import com.travix.medusa.busyflights.utils.create.CrazyAirFactory;
import com.travix.medusa.busyflights.utils.create.ToughJetFactory;

@Service
public class FlightServiceImpl implements FlightService {

	private final FlightClientService flightClientService;

	public FlightServiceImpl(FlightClientService flightClientService) {
		this.flightClientService = flightClientService;
	}

	@Override
	public List<BusyFlightsResponse> findAllFlights(String origin, String destination, String departureDate, String returnDate, int passengers)
			throws InterruptedException {

		List<BusyFlightsResponse> allFlights = new ArrayList<>();

		CompletableFuture<List<BusyFlightsResponse>> crazyAirFlightsFuture = this.findCrazyAirFlights(origin, destination, departureDate, returnDate,
				passengers);
		CompletableFuture<List<BusyFlightsResponse>> toughtJetFlightsFuture = this.findToughJetFlights(origin, destination, departureDate, returnDate,
				passengers);

		CompletableFuture.allOf(crazyAirFlightsFuture, toughtJetFlightsFuture).thenAcceptAsync(it -> {
			List<BusyFlightsResponse> crazyAirFlights = crazyAirFlightsFuture.join();
			if (crazyAirFlights != null) {
				allFlights.addAll(crazyAirFlights);
			}

			List<BusyFlightsResponse> toughtJetFlights = toughtJetFlightsFuture.join();
			if (toughtJetFlights != null) {
				allFlights.addAll(toughtJetFlights);
			}
			Collections.sort(allFlights);
		});

		return allFlights;
	}

	@Async
	private CompletableFuture<List<BusyFlightsResponse>> findCrazyAirFlights(String origin, String destination, String departureDate, String returnDate,
			int passengers) throws InterruptedException {
		CrazyAirRequest request = CrazyAirFactory.createCrazyAirRequest(origin, destination, departureDate, returnDate, passengers);
		List<CrazyAirResponse> crazyAirResponses = flightClientService.findCrazyAirFlights(request);
		List<BusyFlightsResponse> results = CrazyAirFlightConverter.convertToBusyFlights(crazyAirResponses);
		return CompletableFuture.completedFuture(results);
	}

	@Async
	private CompletableFuture<List<BusyFlightsResponse>> findToughJetFlights(String origin, String destination, String departureDate, String returnDate,
			int passengers) throws InterruptedException {
		ToughJetRequest request = ToughJetFactory.createToughJetRequest(origin, destination, departureDate, returnDate, passengers);
		List<ToughJetResponse> toughJetResponses = flightClientService.findToughJetFlights(request);
		List<BusyFlightsResponse> results = ToughFlightConverter.convertToBusyFlights(toughJetResponses);
		return CompletableFuture.completedFuture(results);
	}

}
