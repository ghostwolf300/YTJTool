package com.ytjtool.pojo;

import java.sql.Date;

public class BisCompanyRegisteredEntry {
	
	private String businessId=null;
	private String description=null;
	private int status=-1; //Nolla tarkoittaa yhteisi� merkint�j�, yksi �Rekister�im�t�n� ja kaksi �Rekister�ity�
	private Date registrationDate=null;
	private Date endDate=null;
	private int register=-1;
	//Yksi tarkoittaa kaupparekisteri�, kaksi s��ti�rekisteri�, kolme yhdistysrekisteri�, nelj� Verohallintoa, viisi ennakkoperint�rekisteri�, kuusi arvonlis�verovelvollisten rekisteri�, seitsem�n ty�nantajarekisteri� ja kahdeksan vakuutusmaksuverovelvollisten rekisteri�
	private String language=null;
	private int authority=-1; //Yksi tarkoittaa Verohallintoa, kaksi Patentti- ja rekisterihallitusta ja kolme v�est�rekisteri�
	
	public BisCompanyRegisteredEntry() {
		super();
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
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
