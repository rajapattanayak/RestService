package com.scraper.county.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Hays {
	
	private List<HaysData> _data;
	private JSONArray      _jdata;

	public List<HaysData> getListData() {
		return _data;
	}
	public JSONArray getJsonData() {
		return _jdata;
	}

	//Scrape from Web
	public void pullData() 
		throws Exception 
	{		
		HashMap<String, String> data = scrapeFromWeb();
		if (data != null) {
			storeInBean(data);
			storeInJsonArray(data);
			storeInXML(data);
		}		
	}	

	private HashMap<String, String> scrapeFromWeb()
		throws Exception
	{		
		// To-do : Put the actual logic to pull from web		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		return map;		
		
	}

	private void storeInXML(HashMap<String, String> data) {
		// TODO Auto-generated method stub
		
	}

	private void storeInJsonArray(HashMap<String, String> data) 
		throws Exception 
	{
		_jdata = new JSONArray();
		
		for(String key : data.keySet()) {
			JSONObject obj = new JSONObject();
			obj.put(key, data.get(key));
			_jdata.put(obj);
		}		
	}
	
	private void storeInBean(HashMap<String, String> data)
		throws Exception
	{
		_data  = new ArrayList<HaysData>();
		
		HaysData hdata = new HaysData();			
		hdata.setKey1(data.get("key1"));
		hdata.setKey2(data.get("key2"));		
		
		_data.add(hdata);
	}

	//Class to hold the data
	public final class HaysData {
		private String key1;
		private String key2;
		
		public HaysData() {}
		
		public String getKey1() {
			return key1;
		}
		public void setKey1(String key1) {
			this.key1 = key1;
		}
		public String getKey2() {
			return key2;
		}
		public void setKey2(String key2) {
			this.key2 = key2;
		}
		
		@Override
		public String toString() {
			return "key1:" + getKey1() + "key2:" + getKey2();
		}
	}
}
