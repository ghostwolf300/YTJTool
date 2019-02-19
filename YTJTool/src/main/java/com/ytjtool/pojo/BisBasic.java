package com.ytjtool.pojo;

import java.sql.Date;

public abstract class BisBasic {
	protected String businessId=null;
	protected int source=-1; 
	//Nolla tarkoittaa yhteist�, yksi Patentti- ja rekisterihallitusta, kaksi Verohallintoa ja kolme yritys- ja yhteis�tietoj�rjestelm��
	protected int version=-1;
	//Yksi tarkoittaa nykyist� versiota ja >1 historiallisia osoitteita
	protected Date registrationDate=null;
	protected Date endDate=null;
	protected String language=null;
	
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
