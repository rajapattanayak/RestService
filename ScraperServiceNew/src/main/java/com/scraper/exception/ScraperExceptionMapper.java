package com.scraper.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.scraper.message.ErrorMessage;

@Provider
public class ScraperExceptionMapper implements ExceptionMapper<ScraperException> {
	
	@Override
	public Response toResponse(ScraperException ex) {		
		ErrorMessage errorMsg = new ErrorMessage(ex.getMessage(),404);
		return Response.status(Status.NOT_FOUND).entity(errorMsg).build();	}		
}