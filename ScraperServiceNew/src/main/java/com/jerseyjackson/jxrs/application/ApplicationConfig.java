package com.jerseyjackson.jxrs.application;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/service")
public class ApplicationConfig extends Application {
	  
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();	
		System.out.println("REST configuration starting: getClasses()");
	
		//features this will register Jackson JSON providers
		resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);
		//we could also use this:
		//resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
	
		
		resources.add(com.jerseyjackson.jxrs.provider.JacksonJsonProvider.class);
		resources.add(com.scraper.message.ServiceInfo.class);
		resources.add(com.scraper.service.V1_CountyService.class);
			
		System.out.println("REST configuration ended successfully.");
	
		return resources;
	 }
	
	 @Override
	 public Set<Object> getSingletons() {
		 return Collections.emptySet();
	 }
	
	 @Override
	 public Map<String, Object> getProperties() {
		 Map<String, Object> properties = new HashMap<>();		
		 properties.put("jersey.config.server.wadl.disableWadl", true);
	
		 //we could also use something like this instead of adding each of our resources explicitly in getClasses():
		 //properties.put("jersey.config.server.provider.packages", "com.scraper.service");	
		 return properties;
	 } 

}
