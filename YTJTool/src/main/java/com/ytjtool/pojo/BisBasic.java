package com.ytjtool.pojo;

public abstract class BisBasic {
	private int source=-1; 
	//Nolla tarkoittaa yhteistä, yksi Patentti- ja rekisterihallitusta, kaksi Verohallintoa ja kolme yritys- ja yhteisötietojärjestelmää
	private int version=-1;
	//Yksi tarkoittaa nykyistä versiota ja >1 historiallisia osoitteita
	private String registrationDate=null;
	private String endDate=null;
	private String language=null;
	
	public BisBasic() {
		
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

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
