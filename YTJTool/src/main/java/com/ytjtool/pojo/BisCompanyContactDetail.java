package com.ytjtool.pojo;

public class BisCompanyContactDetail extends BisBasic {
	
	private String value=null; //Yhteystiedon arvo
	private String type=null; //Yhteystiedon laji
	
	public BisCompanyContactDetail() {
		super();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
