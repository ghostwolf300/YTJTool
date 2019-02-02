package com.ytjtool.control;

import com.ytjtool.net.YTJService;
import com.ytjtool.pojo.BisCompanyDetails;

public class YTJTool {
	
	private YTJService service=null;
	
	public YTJTool() {
		service=new YTJService();
	}
	
	public static void main(String[] args) {
		YTJTool tool=new YTJTool();
		tool.findCompanyDetails("0683483-1");

	}
	
	private void findCompanyDetails(String businessId) {
		BisCompanyDetails companyDetails=service.getCompanyDetails(businessId);
	}
	

}
