package com.scrapper.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	
	@Override 
	public Response toResponse(Throwable ex) {		
		return Response.status(500).entity("Server Can not process the request").build();
		
	}		
}
