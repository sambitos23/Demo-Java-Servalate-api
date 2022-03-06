package com.demo.pogo;

import java.sql.Date;

public class Actor {
	private int id;
	private String firstName;	
	private String lastName;
	private Date lastUpdated;
	
	
	public Actor(int id, String firstName, String lastName, Date lastUpdated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdated = lastUpdated;
	}

	

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Date getLastUpdated() {
		return lastUpdated;
	}



	public void setLastUpdated(Date date) {
		this.lastUpdated = date;
	}



	public Actor(String firstName, String lastName, Date lastUpdated) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdated = lastUpdated;
	}

}
