package com.ytjtool.pojo;

public class BisCompanyLiquidation extends BisBasic {
	
	private String name=null; //Tieto mahdollisesta konkurssi-, selvitystila- tai saneerausmenettelystä ,
	private String type=null; //Selvitystilan laji
	
	public BisCompanyLiquidation() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
