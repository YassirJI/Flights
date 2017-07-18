package com.travix.medusa.busyflights.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service.impl.FlightServiceImpl;
import com.travix.medusa.busyflights.service.rest.FlightClientService;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {

	@Mock
	private FlightClientService flightClientService;
	private FlightService flightService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		flightService = new FlightServiceImpl(flightClientService);
	}

	@Test
	public void testFindAllFlights() throws InterruptedException {
		Mockito.when(flightClientService.findCrazyAirFlights(Mockito.any(CrazyAirRequest.class))).thenReturn(getCrazyAirFlights());
		Mockito.when(flightClientService.findToughJetFlights(Mockito.any(ToughJetRequest.class))).thenReturn(getToughJetFlights());

		List<BusyFlightsResponse> allFlights = flightService.findAllFlights("", "", "", "", 1);

		// assertEquals(3, allFlights.size());
	}

	private List<ToughJetResponse> getToughJetFlights() {
		List<ToughJetResponse> results = new ArrayList<>();

		ToughJetResponse jetResponse = new ToughJetResponse();
		jetResponse.setArrivalAirportName("arrivalAirportNameTought");
		jetResponse.setBasePrice(90);
		jetResponse.setCarrier("Carrier");
		jetResponse.setDepartureAirportName("DepartureAirportNameTought");
		jetResponse.setDiscount(30);
		jetResponse.setInboundDateTime("inboundDateTimeTough");
		jetResponse.setOutboundDateTime("outboundDateTimeTough");
		jetResponse.setTax(12);
		results.add(jetResponse);

		return results;
	}

	private List<CrazyAirResponse> getCrazyAirFlights() {
		List<CrazyAirResponse> results = new ArrayList<>();

		CrazyAirResponse crazy = new CrazyAirResponse();
		crazy.setAirline("airlineCrazy");
		crazy.setArrivalDate("arrivalDateCrazy");
		crazy.setDepartureAirportCode("departureAirportCodeCrazy");
		crazy.setDepartureDate("departureDateCrazy");
		crazy.setDestinationAirportCode("destinationAirportCodeCrazy");
		crazy.setPrice(80.12);
		crazy.setCabinclass("cabinclassCrazy");

		CrazyAirResponse crazy2 = new CrazyAirResponse();
		crazy2.setAirline("airlineCrazy");
		crazy2.setArrivalDate("arrivalDateCrazy");
		crazy2.setDepartureAirportCode("departureAirportCodeCrazy");
		crazy2.setDepartureDate("departureDateCrazy");
		crazy2.setDestinationAirportCode("destinationAirportCodeCrazy");
		crazy2.setPrice(20.12);
		crazy2.setCabinclass("cabinclassCrazy");

		results.add(crazy);
		results.add(crazy2);

		return results;
	}
}
