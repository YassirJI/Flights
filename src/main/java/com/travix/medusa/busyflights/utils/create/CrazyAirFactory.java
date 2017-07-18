package com.travix.medusa.busyflights.utils.create;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;

public class CrazyAirFactory {

	public static CrazyAirRequest createCrazyAirRequest(String origin, String destination, String departureDate, String returnDate, int passengers) {
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(origin);
		crazyAirRequest.setDepartureDate(departureDate);
		crazyAirRequest.setDestination(destination);
		crazyAirRequest.setReturnDate(returnDate);
		crazyAirRequest.setPassengerCount(passengers);
		return crazyAirRequest;
	}
}
