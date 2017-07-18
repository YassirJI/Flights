package com.travix.medusa.busyflights.utils.create;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

public class ToughJetFactory {

	public static ToughJetRequest createToughJetRequest(String origin, String destination, String departureDate, String returnDate, int passengers) {
		ToughJetRequest toughJetRequest = new ToughJetRequest();
		toughJetRequest.setFrom(origin);
		toughJetRequest.setOutboundDate(departureDate);
		toughJetRequest.setTo(destination);
		toughJetRequest.setInboundDate(returnDate);
		toughJetRequest.setNumberOfAdults(passengers);
		return toughJetRequest;
	}
}
