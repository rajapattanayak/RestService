package com.scraper.authentication;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.scraper.message.ErrorMessage;

public class Authentication {
	
	public static boolean isAuthenticated(String apiKey) {		
		if ((apiKey == null || apiKey == "")
				|| (apiKey != null
					&& !apiKey.equals(ApiKey.key))) 
		{			
			//ErrorMessage errmsg = new ErrorMessage("You are not authorized to access the service, check your api key", 401);
			//Response response   = Response.status(Status.UNAUTHORIZED).entity(errmsg).build();
			//throw new WebApplicationException(response);
			return false;
		}		
		return true;
	}	

}
