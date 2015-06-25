package com.scraper.county.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HaysData {
	
	private String id;
	private String msg;
	
	public HaysData() {}
	
	public HaysData(String id, String msg) {
		this.id  = id;
		this.msg = msg;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "Id:" + getId() + "Msg:" + getMsg();
	}

}
