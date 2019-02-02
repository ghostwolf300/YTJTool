package com.ytjtool.pojo;

public class BisCompanyName extends BisBasic {
	
	private int order=-1;
	private String name=null;
	
	public BisCompanyName() {
		super();
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
