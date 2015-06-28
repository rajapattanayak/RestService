package com.scraper.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.scraper.county.model.HaysData;
import com.scraper.county.services.HaysService;
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
	public List<HaysData> getHaysDataJson(@QueryParam ("id") String strId)
	{
		List<HaysData> listData = new ArrayList<HaysData>();
		
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
	@Path("/hays/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<HaysData> getHaysDataXml(@QueryParam ("id") String strId) {
		return getHaysDataJson(strId);	
	}
	
	@GET
	@Path("/hays")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getHaysData(
			@QueryParam ("id") String strId,
			@QueryParam ("format") String format)
	{
		
		List<HaysData> haysdata = getHaysDataJson(strId);
		
		return Response.ok(haysdata, "json".equals(format) ? MediaType.APPLICATION_JSON : MediaType.APPLICATION_XML)
        .build();		
		
	}

}
