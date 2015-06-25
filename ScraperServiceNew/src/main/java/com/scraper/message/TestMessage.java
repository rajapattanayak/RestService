package com.scraper.message;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestMessage {
	
	private String serviceName;
	private String serviceVersion;

	public TestMessage() 	{}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceVersion() {
		return serviceVersion;
	}
	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

}
