package com.scraper.county;

import java.util.List;

import org.json.JSONArray;

import com.scraper.county.data.Hays;
import com.scraper.county.data.Hays.HaysData;


public final class County implements ICounty {

	private String _countyname;
	private Idata  _data;
	
	public County(String countyname) {
		_countyname = countyname;
	}
	
	@Override
	public String getName() {
		return _countyname;
		
	}
	
	@Override
	public Idata getData() {
		return _data;
		
	}
	
	public enum Name {
		HAYS;
		public static boolean isValid(String name) {
			if (null == name || name.equals("")) {
				return false;
			}
			for(Name value : Name.values()) {
				if(name.toUpperCase().equals((value.toString()))) {
					return true;
				}
			}
			return false;
		}
	}
	
	public interface Idata{
		List<?>   getListData();
		JSONArray getJsonData();
	}
	
	//pull Data
	public void pullData() 
		throws Exception 
	{
		if (getName().equals(Name.HAYS.toString())) {
			//Get Hays data			
			Hays hays = new Hays();
			hays.pullData();
			final List<HaysData> data  = hays.getListData();
			final JSONArray      jdata = hays.getJsonData();
			
			_data = new Idata() {
				public List<HaysData> getListData()    { return data; }
				public JSONArray      getJsonData()    { return jdata; }
			};
		}		
	}
	
}
