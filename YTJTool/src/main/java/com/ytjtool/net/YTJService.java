package com.ytjtool.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ytjtool.pojo.BisCompanyDetails;

public class YTJService {
	
	public static final String API_URI="http://avoindata.prh.fi/bis/v1";
	
	public YTJService() {
		
	}
	
	public BisCompanyDetails getCompanyDetails(String businessId) {
		HttpURLConnection conn = null;
		JSONObject companyJson=null;
		String urlParams="businessId="+businessId;
		System.out.println(urlParams);
		try {
			URL url=new URL(API_URI+"/"+businessId);
			conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Content-Length", ""+Integer.toString(urlParams.getBytes().length));
			//conn.setRequestProperty("Content-Language", "en-US");
			conn.setUseCaches (false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			DataOutputStream out=new DataOutputStream(conn.getOutputStream());
			
			out.writeBytes(urlParams);
			out.flush();
			out.close();
			
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
		
		return null;
	}
	
	
}
