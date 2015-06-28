package com.scraper.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.scraper.message.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	
	static {
		System.out.println("GenericExceptionMapper being loaded");
	}
	
	public GenericExceptionMapper() {
		System.out.println("GenericExceptionMapper object being created");
	}
	@Override 
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMsg = new ErrorMessage("Server Can not process the request",500);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMsg).build();
		
	}		
}
