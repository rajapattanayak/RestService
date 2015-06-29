package com.scraper.authentication;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.scraper.exception.AuthException;

@PreMatching
@Provider
public class SecurityFilter implements ContainerRequestFilter {
	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public void filter(ContainerRequestContext containerRequest)
			throws WebApplicationException 
	{
		String apiKey = containerRequest.getHeaderString(AUTHENTICATION_HEADER);	

		boolean authenticationStatus = UserAuthentication.isAuthenticated(apiKey);

		if (!authenticationStatus) {	
			throw new AuthException( "Authentication failure, Check your apikey");
		}	

	}

}
