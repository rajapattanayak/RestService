package com.scraper.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.scraper.county.County;
import com.scraper.county.County.Idata;
import com.scraper.message.TestMessage;

/*
 * Version 1 Services for the Scraper
 */
@Path("/v1")
public class V1_CountyService {
	
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
	
	@GET
	@Path("/messages/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<TestMessage> getTestMessageXML() throws Exception			
	{
		List<TestMessage> messages = new ArrayList<TestMessage>();
		TestMessage msg1 = new TestMessage();
		msg1.setServiceName("Scraper Service");
		msg1.setServiceVersion("1.0.0");
		messages.add(msg1);		
		
		TestMessage msg2 = new TestMessage();
		msg2.setServiceName("Test Service");
		msg2.setServiceVersion("1.0.0");
		messages.add(msg2);		
		return messages;		
	}
	
	@GET
	@Path("/messages/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TestMessage> getTestMessageJson() throws Exception			
	{
		List<TestMessage> messages = new ArrayList<TestMessage>();
		TestMessage msg1 = new TestMessage();
		msg1.setServiceName("Scraper Service");
		msg1.setServiceVersion("1.0.0");
		messages.add(msg1);		
		
		TestMessage msg2 = new TestMessage();
		msg2.setServiceName("Test Service");
		msg2.setServiceVersion("1.0.0");
		messages.add(msg2);		
		return messages;		
	}

	
	
	
	/* Actual Services */
	@GET
	@Path("/{CountyName}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getCountyData(@PathParam("CountyName") String countyName,
			@QueryParam("OutputFormat") String outputFormat) 
			throws Exception 
	{
		//String response = null;
		County county   = null ;		
		
		if (!County.Name.isValid(countyName)) {			
			return Response.status(400).entity("Error : Services for the county "
					+ countyName
					+ " is not avilable").build();
		}
	
		
		//HAYS
		if (County.Name.valueOf(countyName.toUpperCase()) == County.Name.HAYS) {
			county = new County(County.Name.HAYS.toString());
			county.pullData();
			Idata data = county.getData();
			return Response.status(200)
					.entity(data.getListData())
					.header(HttpHeaders.CONTENT_TYPE, "json".equals(outputFormat)
							? MediaType.APPLICATION_JSON : MediaType.APPLICATION_XML)
					.build();
					
		}		 
		
		return Response.status(500).entity("Server was not ready to process your request").build();
	}

}
