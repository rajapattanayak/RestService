package com.scraper.authentication;


public class UserAuthentication {
	
	public static boolean isAuthenticated(String apiKey) {		
		if ((apiKey == null || apiKey == "")
				|| (apiKey != null
					&& !apiKey.equals(ApiKey.key))) 
		{			
			return false;
		}		
		return true;
	}	

}
