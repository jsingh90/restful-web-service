package com.java.spring.restfulwebservices.users;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
	private Integer id;
	private String name;
	private LocalDateTime dob;
	
	public User(Integer id, String name, LocalDateTime dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	
	
	
}
