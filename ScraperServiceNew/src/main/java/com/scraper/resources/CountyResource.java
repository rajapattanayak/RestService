package com.scraper.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.scraper.county.model.hays.HaysData;
import com.scraper.county.services.HaysService;
import com.scraper.exception.ScraperException;
import com.scraper.message.ServiceInfo;

/*
 * Version 1 Services for the Scraper
 */
@Path("/v1")
public class CountyResource {
	
	private static final String S_Service = "Scraper Service";
	private static final String S_Version = "1.0.0";
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersionPlain() {
		return "Scraper Service :: Version :" + S_Version;
	}	
	@GET
	@Path("/version/xml")
	@Produces({MediaType.APPLICATION_XML})
	public ServiceInfo getVersion()			
	{		
		ServiceInfo info = new ServiceInfo();
		info.setServiceName(S_Service);
		info.setServiceVersion("1.0.0");				
		return info;		
	}	
	@GET
	@Path("/version/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceInfo getVersionJson()			
	{
		return getVersion();	
	}
	
	
	/* Scraper Services */
	
	//Hays
	@Path("/hays")	
	public HaysResource getHaysResource()
	{
		return new HaysResource();
	}	
	

}
