package com.ytjtool.pojo;

public class BisCompanyRegisteredEntry {
	
	private String description=null;
	private int status=-1; //Nolla tarkoittaa yhteisiä merkintöjä, yksi ”Rekisteröimätön” ja kaksi ”Rekisteröity”
	private String registrationDate=null;
	private String endDate=null;
	private int register=-1;
	//Yksi tarkoittaa kaupparekisteriä, kaksi säätiörekisteriä, kolme yhdistysrekisteriä, neljä Verohallintoa, viisi ennakkoperintärekisteriä, kuusi arvonlisäverovelvollisten rekisteriä, seitsemän työnantajarekisteriä ja kahdeksan vakuutusmaksuverovelvollisten rekisteriä
	private String language=null;
	private int authority=-1; //Yksi tarkoittaa Verohallintoa, kaksi Patentti- ja rekisterihallitusta ja kolme väestörekisteriä
	
	public BisCompanyRegisteredEntry() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getRegister() {
		return register;
	}

	public void setRegister(int register) {
		this.register = register;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	
}
