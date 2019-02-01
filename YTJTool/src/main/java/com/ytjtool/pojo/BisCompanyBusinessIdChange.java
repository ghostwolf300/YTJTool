package com.ytjtool.pojo;

public class BisCompanyBusinessIdChange {
	
	private int source=-1; //Nolla tarkoittaa yhteistä, yksi Patentti- ja rekisterihallitusta, kaksi Verohallintoa ja kolme yritys- ja yhteisötietojärjestelmää ,
	private String description=null;
	private String reason=null;
	private String changeDate=null;
	private String change=null;
	//2 = Yritystunnusten käytöstä poisto, 3 = Tuplatunnusten yhdistäminen, 5 = Tunnusmuutos, 44 = Sulautuminen, 45 = Alv-toiminnan jatkaja, 46 = Edeltäjä-suhde, 47 = Jakautuminen, 48 = Konkurssisuhde, 49 = Jatkaminen yksityisenä elinkeinonharjoittajana, 57 = Osittaisjakautuminen, DIF = Jakautuminen, FUU = Sulautuminen
	private String oldBusinessId=null;
	private String newBusinessId=null;
	private String language=null;
	
	public BisCompanyBusinessIdChange() {
		super();
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

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
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
	
}
