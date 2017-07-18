package com.travix.medusa.busyflights.domain.toughjet;

import java.io.Serializable;
import java.util.List;

public class ToughJetResponseWrapper implements Serializable {

	private static final long serialVersionUID = 435929288241984553L;

	List<ToughJetResponse> toughJetResponses;

	public List<ToughJetResponse> getToughJetResponses() {
		return toughJetResponses;
	}

	public void setToughJetResponses(List<ToughJetResponse> toughJetResponses) {
		this.toughJetResponses = toughJetResponses;
	}
}
