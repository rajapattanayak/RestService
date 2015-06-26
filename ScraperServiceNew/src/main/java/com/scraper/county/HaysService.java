package com.scraper.county;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scraper.county.model.HaysData;


public class HaysService {
	
	private List<HaysData> _data;
	private Map<Integer, HaysData> _dataMap = new HashMap<Integer, HaysData>();

	public List<HaysData> getData() {
		return _data;
	}
	
	public HaysData getDataFromId(Integer id) {		
		if (id == null) return null;
		
		HaysData data = null;		
		if(null != _dataMap && _dataMap.size() > 0) {
			if (_dataMap.containsKey(id)) {
				data = _dataMap.get(id);
			}
		}
		return data;		
	}

	public void scrapeData() {
		_data = new ArrayList<HaysData>();
		//Code to pull data from website
		
		//Store it into bean
		HaysData record1 = new HaysData("1000","TestMessage1");
		HaysData record2 = new HaysData("1001","TestMessage2");
		
		//Store the records into list
		_data.add(record1);
		_data.add(record2);
		
		//Store into temp database for testing
		_dataMap.put(1, record1);
		_dataMap.put(2, record2);
	}

}
