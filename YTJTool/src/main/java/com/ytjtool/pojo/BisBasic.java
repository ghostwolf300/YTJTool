package com.ytjtool.pojo;

import java.sql.Date;

public abstract class BisBasic {
	private String businessId=null;
	private int source=-1; 
	//Nolla tarkoittaa yhteistä, yksi Patentti- ja rekisterihallitusta, kaksi Verohallintoa ja kolme yritys- ja yhteisötietojärjestelmää
	private int version=-1;
	//Yksi tarkoittaa nykyistä versiota ja >1 historiallisia osoitteita
	private Date registrationDate=null;
	private Date endDate=null;
	private String language=null;
	
	public BisBasic() {
		
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
