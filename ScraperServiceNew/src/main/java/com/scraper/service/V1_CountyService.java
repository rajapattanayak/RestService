package com.scraper.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.scraper.county.HaysService;
import com.scraper.county.model.HaysData;
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
	@Path("/hays/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HaysData> getHaysData() throws Exception 
	{
		HaysService service = new HaysService();
		service.scrapeData();
		return service.getData();		
	}
	@GET
	@Path("/hays/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<HaysData> getHaysDataXml() throws Exception 
	{
		return getHaysData();
	}

}
