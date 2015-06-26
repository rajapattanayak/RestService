package com.scraper.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.scraper.exception.ScraperException;

public class ScraperExceptionMapper implements ExceptionMapper<ScraperException> {
	
	@Override
	public Response toResponse(ScraperException ex) {		
		return Response.status(400).entity(ex.getMessage()).build();	}		
}