package com.travix.medusa.busyflights.service.rest.impl;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponseWrapper;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponseWrapper;
import com.travix.medusa.busyflights.service.rest.FlightClientService;

@Service
public class FlightRestClientServiceImpl implements FlightClientService {

	private static final String FIND_CRAZY_AIR_FLIGHTS_ENDPOINT = "https://api.crazyair.com/flights";
	private static final String FIND_TOUGH_JET_FLIGHTS_ENDPOINT = "https://api.toughjet.com/flights";

	private final RestTemplate restTemplate;

	public FlightRestClientServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public List<CrazyAirResponse> findCrazyAirFlights(CrazyAirRequest request) {
		String url = String.format(FIND_CRAZY_AIR_FLIGHTS_ENDPOINT, request);
		CrazyAirResponseWrapper result = restTemplate.postForObject(url, request, CrazyAirResponseWrapper.class);
		return result.getCrazyAirResponses();
	}

	@Override
	public List<ToughJetResponse> findToughJetFlights(ToughJetRequest request) {
		String url = String.format(FIND_TOUGH_JET_FLIGHTS_ENDPOINT, request);
		ToughJetResponseWrapper result = restTemplate.postForObject(url, request, ToughJetResponseWrapper.class);
		return result.getToughJetResponses();
	}

}
