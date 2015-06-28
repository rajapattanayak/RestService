package com.scraper.county.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.scraper.county.model.hays.HaysData;
import com.scraper.exception.ScraperException;
import com.scraper.message.ErrorMessage;


public class HaysService {
	
	private List<HaysData> _data;
	private Map<Integer, HaysData> _dataMap = new HashMap<Integer, HaysData>();

	public List<HaysData> getData() {
		return _data;
	}
	
	//To-do : Fix the user defined exception. Mapper is not being invoked.
	public HaysData getDataFromId(String id) {
		validate(id);		

		ErrorMessage errmsg = new ErrorMessage("No data found with given id:" + id, 404);
    	Response response = Response.status(Status.NOT_FOUND)
    								.entity(errmsg)
    								.build();
		if(null == _dataMap || _dataMap.size() == 0) {
			//throw new ScraperException( "No data found with given id : " + id);
			throw new WebApplicationException(response);
		}
		if (!_dataMap.containsKey(Integer.parseInt(id))) {
			//throw new ScraperException( "No data found with given id : " + id);
			throw new WebApplicationException(response);
		}

		HaysData data = _dataMap.get(Integer.parseInt(id));		
		return data;
	}

	private void validate(String id) {		
		try {
            Integer.parseInt(id);
        } catch(NumberFormatException e) {        	
            //throw new ScraperException( "Not able to process the request. id is not a number !!");
        	ErrorMessage errmsg = new ErrorMessage("Not able to process the request. id is not a number !!", 404);
        	Response response = Response.status(Status.NOT_FOUND)
        								.entity(errmsg)
        								.build();
        	throw new WebApplicationException(response);
        }

	}

	public void scrapeData() {
		_data = new ArrayList<HaysData>();
		//Code to pull data from website
		
		//Store it into bean
		HaysData record1 = new HaysData(1000,"TestMessage1");
		HaysData record2 = new HaysData(1001,"TestMessage2");
		
		//Store the records into list
		_data.add(record1);
		_data.add(record2);
		
		//Store into temp database for testing
		_dataMap.put(record1.getId(), record1);
		_dataMap.put(record2.getId(), record2);
	}

}
