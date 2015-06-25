package com.scraper.county;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.scraper.county.model.HaysData;

public class Hays {
	
	private List<HaysData> _data;

	public List<HaysData> getListData() {
		return _data;
	}
	
	//New Method
	public void pullDataNew() {
		_data = new ArrayList<HaysData>();
		//Code to pull data from website
		
		//Store it into bean
		HaysData record1 = new HaysData("1","TestMessage1");
		HaysData record2 = new HaysData("2","TestMessage2");
		
		//Store the records into list
		_data.add(record1);
		_data.add(record2);		
	}
	

	//Scrape from Web
	public void pullData() 
		throws Exception 
	{		
		List<HashMap<String, String>> allRecords = scrapeFromWeb();
		if (allRecords != null) {
			storeInBean(allRecords);
			storeInXML(allRecords);
		}		
	}	

	private List<HashMap<String, String>> scrapeFromWeb()
		throws Exception
	{		
		// To-do : Put the actual logic to pull from web
		List<HashMap<String, String>> allRecords = new ArrayList<HashMap<String, String>>();
		
		//Record 1
		HashMap<String, String> recordMap1 = new HashMap<String, String>();
		recordMap1.put("Id", "1");
		recordMap1.put("Msg", "TestMessage1");
		allRecords.add(recordMap1);
		
		//Record 2
		HashMap<String, String> recordMap2 = new HashMap<String, String>();
		recordMap2.put("Id", "2");
		recordMap2.put("Msg", "TestMessage2");
		allRecords.add(recordMap2);
		return allRecords;		
		
	}

	private void storeInXML(List<HashMap<String, String>> allRecords) {
		// TODO Auto-generated method stub
		
	}
	
	private void storeInBean(List<HashMap<String, String>> allRecords)
		throws Exception
	{
		_data  = new ArrayList<HaysData>();
		
		for(HashMap<String, String> record : allRecords) {
			HaysData hdata = new HaysData(record.get("Id"), record.get("Msg") );
			_data.add(hdata);
		}
				

	}
}
