package com.ytjtool.pojo;

public class BisAddress extends BisBasic{
	
	private String careOf=null;
	private String street=null;
	private String postCode=null;
	private String city=null;
	private int type=-1; // Osoitteen laji, käyntiosoite 1 , postiosoite 2
	private String country=null;
	
	public BisAddress() {
		super();
	}

	public String getCareOf() {
		return careOf;
	}

	public void setCareOf(String careOf) {
		this.careOf = careOf;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
