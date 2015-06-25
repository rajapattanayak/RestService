package com.jerseyjackson.jxrs.provider;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class JacksonJsonProvider implements ContextResolver<ObjectMapper> {
 
    final ObjectMapper defaultObjectMapper;
 
    public JacksonJsonProvider() {
    	System.out.println("Instantiate JacksonJsonProvider");
        defaultObjectMapper = createDefaultMapper();
    }
 
    @Override
    public ObjectMapper getContext(Class<?> type) {
    	System.out.println("JacksonJsonProvider.getContext() called with type: "+type);
        return defaultObjectMapper;        
    }
 
    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper(); 
        return result;
    }
}