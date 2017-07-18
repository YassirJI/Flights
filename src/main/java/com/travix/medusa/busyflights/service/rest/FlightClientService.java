package com.travix.medusa.busyflights.service.rest;

import java.util.List;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public interface FlightClientService {

	List<CrazyAirResponse> findCrazyAirFlights(CrazyAirRequest request);

	List<ToughJetResponse> findToughJetFlights(ToughJetRequest request);

}
