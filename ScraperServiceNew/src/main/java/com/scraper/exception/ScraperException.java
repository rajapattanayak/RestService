package com.scraper.exception;

import java.io.Serializable;

public class ScraperException extends Exception implements Serializable 
{	
	private static final long serialVersionUID = 1L;
	
	public ScraperException() {
        super();
    }
    
	public ScraperException(String msg)   {
        super(msg);
    }
 
    public ScraperException(String msg, Exception e)  {
        super(msg, e);
    }	
}