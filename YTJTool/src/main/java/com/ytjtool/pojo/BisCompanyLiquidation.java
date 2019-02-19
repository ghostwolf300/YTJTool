package com.ytjtool.pojo;

public class BisCompanyLiquidation extends BisBasic {
	
	private String description=null; //Tieto mahdollisesta konkurssi-, selvitystila- tai saneerausmenettelyst� ,
	private String type=null; //Selvitystilan laji
	
	public BisCompanyLiquidation() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return description+" reg.: "+registrationDate+" end: "+endDate;
	}
	
	
}
