package com.scraper.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.scraper.county.HaysService;
import com.scraper.county.model.HaysData;
import com.scraper.exception.ScraperException;
import com.scraper.message.ServiceInfo;

/*
 * Version 1 Services for the Scraper
 */
@Path("/v1")
public class V1_CountyService {
	
	private static final String S_Service = "Scraper Service";
	private static final String S_Version = "1.0.0";
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersionPlain() {
		return S_Version;
	}	
	@GET
	@Path("/version/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ServiceInfo getVersion() throws Exception			
	{		
		ServiceInfo info = new ServiceInfo();
		info.setServiceName(S_Service);
		info.setServiceVersion("1.0.0");				
		return info;		
	}	
	@GET
	@Path("/version/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceInfo getVersionJson() throws Exception			
	{
		return getVersion();	
	}
	
	/* Scraper Services */
	
	//Hays
	@GET
	@Path("/hays/json/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HaysData> getHaysDataJson(@QueryParam ("Id") String strId) 
	    throws Exception 
	{
		List<HaysData> listData = new ArrayList<HaysData>();
		
		HaysService service = new HaysService();
		service.scrapeData();
		
		//Return specific
		if (strId != null) {
			try {
	            Integer id = Integer.parseInt(strId);
	            HaysData data = service.getDataFromId(id);
	            if (null != data) {
	            	listData.add(data);
	            	return listData;
	            } else {
	            	throw new ScraperException( "No data found with given id" + id);
	            }
	        } catch(NumberFormatException e) {
	            throw new ScraperException( "Not able to process the request. id is not a number !!");
	        }
		}

		//Return all
		listData = service.getData();
		return listData;		
		
	}
	@GET
	@Path("/hays/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<HaysData> getHaysDataXml() throws Exception 
	{
		HaysService service = new HaysService();
		service.scrapeData();
		return service.getData();		
	}

}
