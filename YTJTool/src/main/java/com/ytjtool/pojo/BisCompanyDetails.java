package com.ytjtool.pojo;

import java.sql.Date;
import java.util.List;

public class BisCompanyDetails {
	
	private String businessId=null;
	private Date registrationDate=null;
	private String companyForm=null;
	private String detailsUri=null;
	private String name=null;
	
	private List<BisCompanyName> names=null;
	private List<BisCompanyName> auxiliaryNames=null;
	private List<BisAddress> addresses=null;
	private List<BisCompanyForm> companyForms=null;
	private List<BisCompanyLiquidation> liquidations=null;
	private List<BisCompanyBusinessLine> businessLines=null;
	private List<BisCompanyLanguage> languages=null;
	private List<BisCompanyRegisteredOffice> registeredOffices=null;
	private List<BisCompanyContactDetail> contactDetails=null;
	private List<BisCompanyRegisteredEntry> registeredEntries=null;
	private List<BisCompanyBusinessIdChange> businessIdChanges=null;
	
	public BisCompanyDetails() {
		
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getCompanyForm() {
		return companyForm;
	}

	public void setCompanyForm(String companyForm) {
		this.companyForm = companyForm;
	}

	public String getDetailsUri() {
		return detailsUri;
	}

	public void setDetailsUri(String detailsUri) {
		this.detailsUri = detailsUri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BisCompanyName> getNames() {
		return names;
	}

	public void setNames(List<BisCompanyName> names) {
		this.names = names;
	}

	public List<BisCompanyName> getAuxiliaryNames() {
		return auxiliaryNames;
	}

	public void setAuxiliaryNames(List<BisCompanyName> auxiliaryNames) {
		this.auxiliaryNames = auxiliaryNames;
	}

	public List<BisAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<BisAddress> addresses) {
		this.addresses = addresses;
	}

	public List<BisCompanyForm> getCompanyForms() {
		return companyForms;
	}

	public void setCompanyForms(List<BisCompanyForm> companyForms) {
		this.companyForms = companyForms;
	}

	public List<BisCompanyLiquidation> getLiquidations() {
		return liquidations;
	}

	public void setLiquidations(List<BisCompanyLiquidation> liquidations) {
		this.liquidations = liquidations;
	}

	public List<BisCompanyBusinessLine> getBusinessLines() {
		return businessLines;
	}

	public void setBusinessLines(List<BisCompanyBusinessLine> businessLines) {
		this.businessLines = businessLines;
	}

	public List<BisCompanyLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(List<BisCompanyLanguage> languages) {
		this.languages = languages;
	}

	public List<BisCompanyRegisteredOffice> getRegisteredOffices() {
		return registeredOffices;
	}

	public void setRegisteredOffices(List<BisCompanyRegisteredOffice> registeredOffices) {
		this.registeredOffices = registeredOffices;
	}

	public List<BisCompanyContactDetail> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<BisCompanyContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<BisCompanyRegisteredEntry> getRegisteredEntries() {
		return registeredEntries;
	}

	public void setRegisteredEntries(List<BisCompanyRegisteredEntry> registeredEntries) {
		this.registeredEntries = registeredEntries;
	}

	public List<BisCompanyBusinessIdChange> getBusinessIdChanges() {
		return businessIdChanges;
	}
	
	public BisCompanyBusinessIdChange getLatestBusinessIdChange() {
		Date d=null;
		BisCompanyBusinessIdChange lastChange=null;
		for(BisCompanyBusinessIdChange idChange : businessIdChanges) {
			if(d==null) {
				d=idChange.getChangeDate();
				lastChange=idChange;
			}
			else if(idChange.getChangeDate().after(d)) {
				d=idChange.getChangeDate();
				lastChange=idChange;
			}
		}
		return lastChange;
	}

	public void setBusinessIdChanges(List<BisCompanyBusinessIdChange> businessIdChanges) {
		this.businessIdChanges = businessIdChanges;
	}
	
}
