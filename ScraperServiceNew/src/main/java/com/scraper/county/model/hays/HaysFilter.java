package com.scraper.county.model.hays;

import javax.ws.rs.QueryParam;

public class HaysFilter {
	
	private @QueryParam ("id") String strId;

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

}
