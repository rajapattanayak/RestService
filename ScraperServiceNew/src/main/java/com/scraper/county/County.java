package com.scraper.county;

import java.util.List;

import com.scraper.county.model.HaysData;
import com.scraper.county.services.HaysService;


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
	}
	
	//pull Data
	public void pullData() 
		throws Exception 
	{
		if (getName().equals(Name.HAYS.toString())) {
			//Get Hays data			
			HaysService hays = new HaysService();
			hays.scrapeData();
			final List<HaysData> data  = hays.getData();
			
			_data = new Idata() {
				public List<HaysData> getListData()    { return data; }
			};
		}		
	}
	
}
