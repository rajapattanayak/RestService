package com.scraper.county.model.hays;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HaysData {
	
	private Integer id;
	private String msg;
	
	public HaysData() {}
	
	public HaysData(Integer id, String msg) {
		this.id  = id;
		this.msg = msg;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
