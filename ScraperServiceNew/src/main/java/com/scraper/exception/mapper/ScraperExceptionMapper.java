package com.scraper.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.scraper.exception.ScraperException;
import com.scraper.message.ErrorMessage;

@Provider
public class ScraperExceptionMapper implements ExceptionMapper<ScraperException> {
	
	static {
		System.out.println("ScraperExceptionMapper being loaded");
	}
	
	public ScraperExceptionMapper() {
		System.out.println("ScraperExceptionMapper object being created");
	}
	@Override
	public Response toResponse(ScraperException ex) {
		System.out.println("calling custom exception response");
		ErrorMessage errorMsg = new ErrorMessage(ex.getMessage(),404);
		return Response.status(Status.NOT_FOUND).entity(errorMsg).build();	}		
}