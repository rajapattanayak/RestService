package com.scraper.county;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.scraper.county.model.HaysData;

public class HaysService {
	
	private List<HaysData> _data;

	public List<HaysData> getListData() {
		return _data;
	}
	
	//New Method
	public void pullData() {
		_data = new ArrayList<HaysData>();
		//Code to pull data from website
		
		//Store it into bean
		HaysData record1 = new HaysData("1","TestMessage1");
		HaysData record2 = new HaysData("2","TestMessage2");
		
		//Store the records into list
		_data.add(record1);
		_data.add(record2);		
	}

}
