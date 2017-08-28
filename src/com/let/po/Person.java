package com.let.po;

public class Person {
	private Long id;
	private String credentials_type;
	private String credentials_id;
	private String personName;
	private String telephone;

	public Person() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCredentials_type() {
		return credentials_type;
	}

	public void setCredentials_type(String credentials_type) {
		this.credentials_type = credentials_type;
	}

	public String getCredentials_id() {
		return credentials_id;
	}

	public void setCredentials_id(String credentials_id) {
		this.credentials_id = credentials_id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
