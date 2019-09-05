package com.ytjtool.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ytjtool.pojo.BisAddress;
import com.ytjtool.pojo.BisCompanyBusinessIdChange;
import com.ytjtool.pojo.BisCompanyBusinessLine;
import com.ytjtool.pojo.BisCompanyContactDetail;
import com.ytjtool.pojo.BisCompanyDetails;
import com.ytjtool.pojo.BisCompanyForm;
import com.ytjtool.pojo.BisCompanyLiquidation;
import com.ytjtool.pojo.BisCompanyName;
import com.ytjtool.pojo.BisCompanyRegisteredEntry;
import com.ytjtool.pojo.BisCompanyRegisteredOffice;

public class YTJService {
	
	public static final String API_URI="http://avoindata.prh.fi/bis/v1";
	
	public YTJService() {
		
	}
	
	public BisCompanyDetails getCompanyDetails(String businessId) {
		
		HttpURLConnection conn = null;
		JSONObject companyJson=null;
		int responseCode=-1;
		
		try {
			URL url=new URL(API_URI+"/"+businessId);
			conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			responseCode=conn.getResponseCode();
			
			if(responseCode==HttpURLConnection.HTTP_OK) {
				//do things
				InputStream in=conn.getInputStream();
				BufferedReader reader=new BufferedReader(new InputStreamReader(in));
				StringBuffer response=new StringBuffer();
				String line=null;
				while((line=reader.readLine())!=null) {
					response.append(line);
				}
				in.close();
				JSONParser parser=new JSONParser();
				companyJson=(JSONObject) parser.parse(response.toString());
			}
			else {
				//System.out.println("HTTP Error "+responseCode);
			}
			
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				conn.disconnect();
			}
		}
		
		//System.out.println(companyJson);
		if(companyJson==null || companyJson.get("results")==null || ((JSONArray) companyJson.get("results")).size()==0) {
			return null;
		}
		else {
			return createCompanyDetails(companyJson);
		}
	}
	
	private BisCompanyDetails createCompanyDetails(JSONObject companyJson) {
		
		BisCompanyDetails companyDetails=new BisCompanyDetails();
		JSONObject resultsJson=(JSONObject) ((JSONArray) companyJson.get("results")).get(0);
		companyDetails.setBusinessId((String) resultsJson.get("businessId"));
		companyDetails.setName((String) resultsJson.get("name"));
		String dateString=(String) resultsJson.get("registrationDate");
		if(dateString!=null) {
			companyDetails.setRegistrationDate(Date.valueOf(dateString));
		}
		companyDetails.setCompanyForm((String) resultsJson.get("companyForm"));
		companyDetails.setDetailsUri((String) resultsJson.get("detailsUri"));
		
		companyDetails.setNames(createCompanyNames(resultsJson));
		companyDetails.setAuxiliaryNames(createAuxiliaryNames(resultsJson));
		companyDetails.setAddresses(createAddresses(resultsJson));
		companyDetails.setCompanyForms(createCompanyForms(resultsJson));
		companyDetails.setBusinessLines(createCompanyBusinessLines(resultsJson));
		companyDetails.setRegisteredOffices(createCompanyOffices(resultsJson));
		companyDetails.setContactDetails(createContactDetails(resultsJson));
		companyDetails.setRegisteredEntries(createRegisteredEntries(resultsJson));
		companyDetails.setBusinessIdChanges(createBusinessIdChanges(resultsJson));
		companyDetails.setLiquidations(createLiquidations(resultsJson));
		return companyDetails;
	}
	
	private List<BisCompanyName> createCompanyNames(JSONObject resultsJson){
		List<BisCompanyName> companyNames=new ArrayList<BisCompanyName>();
		BisCompanyName name=null;
		String businessId=(String) resultsJson.get("businessId");
		JSONArray namesJson=(JSONArray) resultsJson.get("names");
		for(Object nameObj : namesJson) {
			JSONObject nameJson=(JSONObject) nameObj;
			if(nameJson.get("name")!=null) {
				name=new BisCompanyName();
				name.setBusinessId(businessId);
				name.setOrder(Math.toIntExact((Long) nameJson.get("order")));
				name.setVersion(Math.toIntExact((Long) nameJson.get("version")));
				name.setName((String) nameJson.get("name"));
				String regDateString=(String) nameJson.get("registrationDate");
				if(regDateString!=null) {
					name.setRegistrationDate(Date.valueOf(regDateString));
				}
				String endDateString=(String) nameJson.get("endDate");
				if(endDateString!=null) {
					name.setEndDate(Date.valueOf(endDateString));
				}
				name.setSource(Math.toIntExact((Long) nameJson.get("source")));
				companyNames.add(name);
			}
		}
		return companyNames;
	}
	
	private List<BisCompanyName> createAuxiliaryNames(JSONObject resultsJson){
		List<BisCompanyName> auxiliaryNames=new ArrayList<BisCompanyName>();
		BisCompanyName name=null;
		String businessId=(String) resultsJson.get("businessId");
		JSONArray namesJson=(JSONArray) resultsJson.get("auxiliaryNames");
		for(Object nameObj : namesJson) {
			JSONObject nameJson=(JSONObject) nameObj;
			if(nameJson.get("name")!=null) {
				name=new BisCompanyName();
				name.setBusinessId(businessId);
				name.setOrder(Math.toIntExact((Long) nameJson.get("order")));
				name.setVersion(Math.toIntExact((Long) nameJson.get("version")));
				name.setName((String) nameJson.get("name"));
				String regDateString=(String) nameJson.get("registrationDate");
				if(regDateString!=null) {
					name.setRegistrationDate(Date.valueOf(regDateString));
				}
				String endDateString=(String) nameJson.get("endDate");
				if(endDateString!=null) {
					name.setEndDate(Date.valueOf(endDateString));
				}
				name.setSource(Math.toIntExact((Long) nameJson.get("source")));
				auxiliaryNames.add(name);
			}
		}
		return auxiliaryNames;
	}
	
	private List<BisAddress> createAddresses(JSONObject resultsJson){
		List<BisAddress> addresses=new ArrayList<BisAddress>();
		BisAddress address=null;
		String businessId=(String) resultsJson.get("businessId");
		JSONArray addressesJson=(JSONArray) resultsJson.get("addresses");
		for(Object addressObj : addressesJson) {
			JSONObject addressJson=(JSONObject) addressObj;
			address=new BisAddress();
			address.setBusinessId(businessId);
			address.setCareOf((String) addressJson.get("careOf"));
			address.setStreet((String) addressJson.get("street"));
			address.setPostCode((String) addressJson.get("postCode"));
			address.setCity((String) addressJson.get("city"));
			address.setCountry((String) addressJson.get("country"));
			address.setType(Math.toIntExact((Long) addressJson.get("type")));
			address.setVersion(Math.toIntExact((Long) addressJson.get("version")));
			String regDateString=(String) addressJson.get("registrationDate");
			if(regDateString!=null) {
				address.setRegistrationDate(Date.valueOf(regDateString));
			}
			String endDateString=(String) addressJson.get("endDate");
			if(endDateString!=null) {
				address.setEndDate(Date.valueOf(endDateString));
			}
			address.setLanguage((String) addressJson.get("language"));
			addresses.add(address);
		}
		return addresses;
	}
	
	private List<BisCompanyForm> createCompanyForms(JSONObject results){
		List<BisCompanyForm> companyForms=new ArrayList<BisCompanyForm>();
		BisCompanyForm companyForm=null;
		String businessId=(String) results.get("businessId");
		JSONArray formsJson=(JSONArray) results.get("companyForms");
		for(Object formObj : formsJson) {
			JSONObject formJson=(JSONObject) formObj;
			companyForm=new BisCompanyForm();
			companyForm.setBusinessId(businessId);
			companyForm.setName((String) formJson.get("name"));
			String regDateString=(String) formJson.get("registrationDate");
			if(regDateString!=null) {
				companyForm.setRegistrationDate(Date.valueOf(regDateString));
			}
			String endDateString=(String) formJson.get("endDate");
			if(endDateString!=null) {
				companyForm.setEndDate(Date.valueOf(endDateString));
			}
			companyForm.setLanguage((String) formJson.get("language"));
			companyForm.setType((String) formJson.get("type"));
			companyForm.setVersion(Math.toIntExact((Long)formJson.get("version")));
			companyForm.setSource(Math.toIntExact((Long)formJson.get("source")));
			companyForms.add(companyForm);
		}
		return companyForms;
	}
	
	private List<BisCompanyBusinessLine> createCompanyBusinessLines(JSONObject results){
		List<BisCompanyBusinessLine> businessLines=new ArrayList<BisCompanyBusinessLine>();
		BisCompanyBusinessLine businessLine=null;
		String businessId=(String) results.get("businessId");
		JSONArray linesJson=(JSONArray) results.get("businessLines");
		for(Object lineObj : linesJson) {
			JSONObject lineJson=(JSONObject) lineObj;
			businessLine=new BisCompanyBusinessLine();
			businessLine.setBusinessId(businessId);
			businessLine.setName((String) lineJson.get("name"));
			String regDateString=(String) lineJson.get("registrationDate");
			if(regDateString!=null) {
				businessLine.setRegistrationDate(Date.valueOf(regDateString));
			}
			String endDateString=(String) lineJson.get("endDate");
			if(endDateString!=null) {
				businessLine.setEndDate(Date.valueOf(endDateString));
			}
			businessLine.setLanguage((String) lineJson.get("language"));
			businessLine.setVersion(Math.toIntExact((Long) lineJson.get("version")));
			businessLine.setSource(Math.toIntExact((Long) lineJson.get("source")));
			businessLines.add(businessLine);
		}
		return businessLines;
	}
	
	private List<BisCompanyRegisteredOffice> createCompanyOffices(JSONObject results){
		List<BisCompanyRegisteredOffice> offices=new ArrayList<BisCompanyRegisteredOffice>();
		BisCompanyRegisteredOffice office=null;
		String businessId=(String) results.get("businessId");
		JSONArray officesJson=(JSONArray) results.get("registedOffices");
		for(Object officeObj : officesJson) {
			JSONObject officeJson=(JSONObject) officeObj;
			office=new BisCompanyRegisteredOffice();
			office.setBusinessId(businessId);
			office.setName((String) officeJson.get("name"));
			String regDateString=(String) officeJson.get("registrationDate");
			if(regDateString!=null) {
				office.setRegistrationDate(Date.valueOf(regDateString));
			}
			String endDateString=(String) officeJson.get("endDate");
			if(endDateString!=null) {
				office.setEndDate(Date.valueOf(endDateString));
			}
			office.setLanguage((String) officeJson.get("language"));
			office.setSource(Math.toIntExact((Long) officeJson.get("source")));
			office.setVersion(Math.toIntExact((Long) officeJson.get("version")));
			offices.add(office);
		}
		return offices;
	}
	
	private List<BisCompanyContactDetail> createContactDetails(JSONObject results){
		List<BisCompanyContactDetail> details=new ArrayList<BisCompanyContactDetail>();
		BisCompanyContactDetail detail=null;
		String businessId=(String) results.get("businessId");
		JSONArray detailsJson=(JSONArray) results.get("contactDetails");
		for(Object detailObj : detailsJson) {
			JSONObject detailJson=(JSONObject) detailObj;
			detail=new BisCompanyContactDetail();
			detail.setBusinessId(businessId);
			detail.setValue((String) detailJson.get("value"));
			detail.setType((String) detailJson.get("type"));
			String regDateString=(String) detailJson.get("registrationDate");
			if(regDateString!=null) {
				detail.setRegistrationDate(Date.valueOf(regDateString));
			}
			String endDateString=(String) detailJson.get("endDate");
			if(endDateString!=null) {
				detail.setEndDate(Date.valueOf(endDateString));
			}
			detail.setLanguage((String) detailJson.get("language"));
			detail.setSource(Math.toIntExact((Long) detailJson.get("source")));
			detail.setVersion(Math.toIntExact((Long) detailJson.get("version")));
			details.add(detail);
		}
		return details;
	}
	
	private List<BisCompanyRegisteredEntry> createRegisteredEntries(JSONObject results){
		List<BisCompanyRegisteredEntry> entries=new ArrayList<BisCompanyRegisteredEntry>();
		BisCompanyRegisteredEntry entry=null;
		String businessId=(String) results.get("businessId");
		JSONArray entriesJson=(JSONArray) results.get("registeredEntries");
		for(Object entryObj : entriesJson) {
			JSONObject entryJson=(JSONObject) entryObj;
			entry=new BisCompanyRegisteredEntry();
			entry.setBusinessId(businessId);
			entry.setAuthority(Math.toIntExact((Long) entryJson.get("authority")));
			entry.setDescription((String) entryJson.get("description"));
			entry.setRegister(Math.toIntExact((Long) entryJson.get("register")));
			entry.setStatus(Math.toIntExact((Long) entryJson.get("status")));
			String regDateString=(String) entryJson.get("registrationDate");
			if(regDateString!=null) {
				entry.setRegistrationDate(Date.valueOf(regDateString));
			}
			String endDateString=(String) entryJson.get("endDate");
			if(endDateString!=null) {
				entry.setEndDate(Date.valueOf(endDateString));
			}
			entry.setLanguage((String) entryJson.get("language"));
			entries.add(entry);
		}
		return entries;
	}
	
	private List<BisCompanyBusinessIdChange> createBusinessIdChanges(JSONObject results){
		List<BisCompanyBusinessIdChange> idChanges=new ArrayList<BisCompanyBusinessIdChange>();
		BisCompanyBusinessIdChange idChange=null;
		String businessId=(String) results.get("businessId");
		JSONArray idChangesJson=(JSONArray) results.get("businessIdChanges");
		for(Object idChangeObj : idChangesJson) {
			
			JSONObject idChangeJson=(JSONObject) idChangeObj;
			String language=(String) idChangeJson.get("language");
			
			idChange=new BisCompanyBusinessIdChange();
			idChange.setBusinessId(businessId);
			idChange.setChange((String) idChangeJson.get("change"));
			String changeDateString=(String) idChangeJson.get("changeDate");
			if(changeDateString!=null) {
				idChange.setChangeDate(Date.valueOf(changeDateString));
			}
			idChange.setOldBusinessId((String) idChangeJson.get("oldBusinessId"));
			idChange.setNewBusinessId((String) idChangeJson.get("newBusinessId"));
			idChange.setLanguage(language);
			idChange.setDescription((String) idChangeJson.get("description"));
			idChange.setSource(Math.toIntExact((Long) idChangeJson.get("source")));
			idChanges.add(idChange);
			
		}
		return idChanges;
	}
	
	private List<BisCompanyLiquidation> createLiquidations(JSONObject results){
		List<BisCompanyLiquidation> liquidations=new ArrayList<BisCompanyLiquidation>();
		BisCompanyLiquidation liq=null;
		String businessId=(String) results.get("businessId");
		JSONArray liquidationsJson=(JSONArray) results.get("liquidations");
		for(Object liqObj : liquidationsJson) {
			JSONObject liqJson=(JSONObject) liqObj;
			liq=new BisCompanyLiquidation();
			liq.setBusinessId(businessId);
			liq.setType((String) liqJson.get("type"));
			liq.setDescription((String) liqJson.get("description"));
			liq.setRegistrationDate(Date.valueOf((String) liqJson.get("registrationDate")));
			String endDateString=(String) liqJson.get("endDate");
			if(endDateString!=null) {
				liq.setEndDate(Date.valueOf(endDateString));
			}
			liq.setVersion(Math.toIntExact((Long) liqJson.get("version")));
			liq.setSource(Math.toIntExact((Long) liqJson.get("source")));
			liq.setLanguage((String) liqJson.get("language"));
			liquidations.add(liq);
		}
		return liquidations;
	}
	
	
}
