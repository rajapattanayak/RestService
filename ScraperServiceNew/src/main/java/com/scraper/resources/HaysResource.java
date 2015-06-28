package com.scraper.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.scraper.county.model.hays.HaysData;
import com.scraper.county.model.hays.HaysFilter;
import com.scraper.county.services.HaysService;

@Path("/")
public class HaysResource {
	
	/*
	 * To-do : Its not returning xml even if Content-Type = "application/xml"
	 * Need to work on it.
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<HaysData> getHaysData(@QueryParam ("id") String strId)
	{		
		return getHaysDataJson(strId);		
	}
	*/

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HaysData> getHaysData(@BeanParam HaysFilter filterdata)
	{
		List<HaysData> listData = new ArrayList<HaysData>();
		
		//Input filter from client
		String strId = filterdata.getStrId();
		
		//Get data
		HaysService service = new HaysService();
		service.scrapeData();
		
		//Return specific
		if (strId != null) {		
			HaysData data = service.getDataFromId(strId);
	    	listData.add(data);
	    	return listData;
		}

		//Return all
		listData = service.getData();
		return listData;		
		
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<HaysData> getHaysDataXml(@BeanParam HaysFilter filterdata) {
		return getHaysData(filterdata);		

	}

}
