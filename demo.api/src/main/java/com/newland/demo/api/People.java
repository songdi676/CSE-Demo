package com.newland.demo.api;

import java.io.Serializable;

public class People implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -4093927848930419910L;
	private int peopleId;
	private String peopleName;
	private int status;
	private String description;

	public int getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}

	public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
