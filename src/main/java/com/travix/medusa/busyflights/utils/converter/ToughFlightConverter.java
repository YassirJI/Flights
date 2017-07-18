package com.travix.medusa.busyflights.utils.converter;

import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.busyflights.domain.FlightSupplier;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public class ToughFlightConverter {

	public static List<BusyFlightsResponse> convertToBusyFlights(List<ToughJetResponse> toughJetResponses) {
		List<BusyFlightsResponse> results = new ArrayList<>();
		for (ToughJetResponse toughJetResponse : toughJetResponses) {
			results.add(convertToBusyFlight(toughJetResponse));
		}
		return results;
	}

	public static BusyFlightsResponse convertToBusyFlight(ToughJetResponse toughJetResponse) {
		BusyFlightsResponse busyFlight = new BusyFlightsResponse();
		busyFlight.setAirline(toughJetResponse.getCarrier());
		busyFlight.setDepartureDate(toughJetResponse.getInboundDateTime());
		busyFlight.setArrivalDate(toughJetResponse.getOutboundDateTime());
		busyFlight.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
		busyFlight.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
		busyFlight.setSupplier(FlightSupplier.ToughJet.toString());
		double fareValue = (toughJetResponse.getBasePrice() + toughJetResponse.getBasePrice() / 100 * toughJetResponse.getTax())
				- toughJetResponse.getDiscount();
		busyFlight.setFare(fareValue);
		return busyFlight;
	}

}
