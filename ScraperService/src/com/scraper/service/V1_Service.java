package com.scraper.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.scraper.county.County;
import com.scraper.county.County.Idata;
import com.scraper.county.data.Hays.HaysData;

/*
 * Version 1 Services for the Scraper
 */
@Path("/v1")
public class V1_Service {
	
	private static final String S_Version = "1.0.0";
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersion() {
		return S_Version;
	}
	
	@GET
	@Path("/version_xml/")
	@Produces(MediaType.TEXT_XML)
	public String getVersionXml() {
		return "<?xml version=\"1.0\"?>"
				+ "<version>"
				+ S_Version 
				+ "</version>";
	}
	
	@GET
	@Path("/version_html/")
	@Produces(MediaType.TEXT_HTML)
	public String getVersionHtml() {
		return "<html> " + "<title>" + "API Version"
				+ "</title>" + "<body><h1>" + "Version :" + S_Version
				+ "</body></h1>" + "</html> ";
	}
	
	/* Services */
	@GET
	@Path("/{CountyName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCountyData(@PathParam("CountyName") String countyName) 
			throws Exception 
	{
		String response = null;
		County county   = null ;		
		
		if (!County.Name.isValid(countyName)) {			
			return Response.status(400).entity("Error : Services for the county "
					+ countyName
					+ " is not avilable").build();
		}
	
		try {
			//HAYS
			if (County.Name.valueOf(countyName.toUpperCase()) == County.Name.HAYS) {
				county = new County(County.Name.HAYS.toString());
				county.pullData();
				Idata data = county.getData();
				
				response = data.getJsonData().toString();		
			}
		} catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was not ready to process your request").build();
		}
		
		return Response.ok(response).build();
	}

}
