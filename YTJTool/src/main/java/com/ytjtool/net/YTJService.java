package com.ytjtool.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ytjtool.pojo.BisAddress;
import com.ytjtool.pojo.BisCompanyBusinessLine;
import com.ytjtool.pojo.BisCompanyDetails;
import com.ytjtool.pojo.BisCompanyForm;
import com.ytjtool.pojo.BisCompanyName;

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
		
		System.out.println(companyJson);
		
		return createCompanyDetails(companyJson);
	}
	
	private BisCompanyDetails createCompanyDetails(JSONObject companyJson) {
		BisCompanyDetails companyDetails=new BisCompanyDetails();
		JSONObject resultsJson=(JSONObject) ((JSONArray) companyJson.get("results")).get(0);
		companyDetails.setBusinessId((String) resultsJson.get("businessId"));
		companyDetails.setName((String) resultsJson.get("name"));
		companyDetails.setRegistrationDate((String) resultsJson.get("registrationDate"));
		companyDetails.setCompanyForm((String) resultsJson.get("companyForm"));
		companyDetails.setDetailsUri((String) resultsJson.get("detailsUri"));
		companyDetails.setNames(createCompanyNames(resultsJson));
		companyDetails.setAuxiliaryNames(createAuxiliaryNames(resultsJson));
		companyDetails.setAddresses(createAddresses(resultsJson));
		companyDetails.setCompanyForms(createCompanyForms(resultsJson));
		companyDetails.setBusinessLines(createCompanyBusinessLines(resultsJson));
		return companyDetails;
	}
	
	private List<BisCompanyName> createCompanyNames(JSONObject resultsJson){
		List<BisCompanyName> companyNames=new ArrayList<BisCompanyName>();
		BisCompanyName name=null;
		JSONArray namesJson=(JSONArray) resultsJson.get("names");
		for(Object nameObj : namesJson) {
			JSONObject nameJson=(JSONObject) nameObj;
			name=new BisCompanyName();
			name.setOrder(Math.toIntExact((Long) nameJson.get("order")));
			name.setVersion(Math.toIntExact((Long) nameJson.get("version")));
			name.setName((String) nameJson.get("name"));
			name.setRegistrationDate((String) nameJson.get("registrationDate"));
			name.setEndDate((String) nameJson.get("endDate"));
			name.setSource(Math.toIntExact((Long) nameJson.get("source")));
			companyNames.add(name);
		}
		return companyNames;
	}
	
	private List<BisCompanyName> createAuxiliaryNames(JSONObject resultsJson){
		List<BisCompanyName> auxiliaryNames=new ArrayList<BisCompanyName>();
		BisCompanyName name=null;
		JSONArray namesJson=(JSONArray) resultsJson.get("auxiliaryNames");
		for(Object nameObj : namesJson) {
			JSONObject nameJson=(JSONObject) nameObj;
			name=new BisCompanyName();
			name.setOrder(Math.toIntExact((Long) nameJson.get("order")));
			name.setVersion(Math.toIntExact((Long) nameJson.get("version")));
			name.setName((String) nameJson.get("name"));
			name.setRegistrationDate((String) nameJson.get("registrationDate"));
			name.setEndDate((String) nameJson.get("endDate"));
			name.setSource(Math.toIntExact((Long) nameJson.get("source")));
			auxiliaryNames.add(name);
		}
		return auxiliaryNames;
	}
	
	private List<BisAddress> createAddresses(JSONObject resultsJson){
		List<BisAddress> addresses=new ArrayList<BisAddress>();
		BisAddress address=null;
		JSONArray addressesJson=(JSONArray) resultsJson.get("addresses");
		for(Object addressObj : addressesJson) {
			JSONObject addressJson=(JSONObject) addressObj;
			address=new BisAddress();
			address.setCareOf((String) addressJson.get("careOf"));
			address.setStreet((String) addressJson.get("street"));
			address.setPostCode((String) addressJson.get("postCode"));
			address.setCity((String) addressJson.get("city"));
			address.setCountry((String) addressJson.get("country"));
			address.setType(Math.toIntExact((Long) addressJson.get("type")));
			address.setVersion(Math.toIntExact((Long) addressJson.get("version")));
			address.setRegistrationDate((String) addressJson.get("registrationDate"));
			address.setEndDate((String) addressJson.get("endDate"));
			address.setLanguage((String) addressJson.get("language"));
			addresses.add(address);
		}
		return addresses;
	}
	
	private List<BisCompanyForm> createCompanyForms(JSONObject results){
		List<BisCompanyForm> companyForms=new ArrayList<BisCompanyForm>();
		BisCompanyForm companyForm=null;
		JSONArray formsJson=(JSONArray) results.get("companyForms");
		for(Object formObj : formsJson) {
			JSONObject formJson=(JSONObject) formObj;
			companyForm=new BisCompanyForm();
			companyForm.setName((String) formJson.get("name"));
			companyForm.setRegistrationDate((String) formJson.get("registrationDate"));
			companyForm.setEndDate((String) formJson.get("endDate"));
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
		JSONArray linesJson=(JSONArray) results.get("businessLines");
		for(Object lineObj : linesJson) {
			JSONObject lineJson=(JSONObject) lineObj;
			businessLine=new BisCompanyBusinessLine();
			businessLine.setName((String) lineJson.get("name"));
			businessLine.setRegistrationDate((String) lineJson.get("registrationDate"));
			businessLine.setEndDate((String) lineJson.get("endDate"));
			businessLine.setLanguage((String) lineJson.get("language"));
			businessLine.setVersion(Math.toIntExact((Long) lineJson.get("version")));
			businessLine.setSource(Math.toIntExact((Long) lineJson.get("source")));
			businessLines.add(businessLine);
		}
		return businessLines;
	}
	
	
}
