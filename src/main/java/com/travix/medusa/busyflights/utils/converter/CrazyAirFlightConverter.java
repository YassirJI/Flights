package com.travix.medusa.busyflights.utils.converter;

import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.busyflights.domain.FlightSupplier;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

public class CrazyAirFlightConverter {

	public static List<BusyFlightsResponse> convertToBusyFlights(List<CrazyAirResponse> crazyAirResponses) {
		List<BusyFlightsResponse> results = new ArrayList<>();
		for (CrazyAirResponse crazyAirResponse : crazyAirResponses) {
			results.add(convertToBusyFlight(crazyAirResponse));
		}
		return results;
	}

	public static BusyFlightsResponse convertToBusyFlight(CrazyAirResponse crazyAirResponse) {
		BusyFlightsResponse busyFlight = new BusyFlightsResponse();
		busyFlight.setAirline(crazyAirResponse.getAirline());
		busyFlight.setArrivalDate(crazyAirResponse.getArrivalDate());
		busyFlight.setDepartureDate(crazyAirResponse.getDepartureDate());
		busyFlight.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
		busyFlight.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
		busyFlight.setSupplier(FlightSupplier.CrazyAir.toString());
		busyFlight.setFare(crazyAirResponse.getPrice());
		return busyFlight;
	}

}
