package com.travix.medusa.busyflights.domain.crazyair;

import java.io.Serializable;
import java.util.List;

public class CrazyAirResponseWrapper implements Serializable {

	private static final long serialVersionUID = 4540527898107354420L;

	List<CrazyAirResponse> crazyAirResponses;

	public List<CrazyAirResponse> getCrazyAirResponses() {
		return crazyAirResponses;
	}

	public void setCrazyAirResponses(List<CrazyAirResponse> crazyAirResponses) {
		this.crazyAirResponses = crazyAirResponses;
	}

}
