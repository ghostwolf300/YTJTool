package com.ytjtool.pojo;

import java.sql.Date;

public class BisCompanyBusinessIdChange {
	
	private String businessId=null;
	private int source=-1; //Nolla tarkoittaa yhteist�, yksi Patentti- ja rekisterihallitusta, kaksi Verohallintoa ja kolme yritys- ja yhteis�tietoj�rjestelm�� ,
	private String description=null;
	private String reason=null;
	private Date changeDate=null;
	private String change=null;
	//2 = Yritystunnusten k�yt�st� poisto, 3 = Tuplatunnusten yhdist�minen, 5 = Tunnusmuutos, 44 = Sulautuminen, 45 = Alv-toiminnan jatkaja, 46 = Edelt�j�-suhde, 47 = Jakautuminen, 48 = Konkurssisuhde, 49 = Jatkaminen yksityisen� elinkeinonharjoittajana, 57 = Osittaisjakautuminen, DIF = Jakautuminen, FUU = Sulautuminen
	private String oldBusinessId=null;
	private String newBusinessId=null;
	private String language=null;
	
	public BisCompanyBusinessIdChange() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getOldBusinessId() {
		return oldBusinessId;
	}

	public void setOldBusinessId(String oldBusinessId) {
		this.oldBusinessId = oldBusinessId;
	}

	public String getNewBusinessId() {
		return newBusinessId;
	}

	public void setNewBusinessId(String newBusinessId) {
		this.newBusinessId = newBusinessId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String toString() {
		return changeDate+" code: "+change+" old: "+oldBusinessId+" new: "+newBusinessId;
	}
	
}
