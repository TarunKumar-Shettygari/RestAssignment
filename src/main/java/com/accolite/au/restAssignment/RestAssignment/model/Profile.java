package com.accolite.au.restAssignment.RestAssignment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	String name;
	String email_id;
	String password;
	public Profile() {
		
	}
	public Profile(String name, String email_id, String password) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
