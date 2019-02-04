package com.ytjtool.control;

import java.sql.Date;

import com.ytjtool.db.DAOFactory;
import com.ytjtool.db.ICompanyDAO;
import com.ytjtool.net.YTJService;
import com.ytjtool.pojo.BisAddress;
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
		BisCompanyDetails company=service.getCompanyDetails(businessId);
		ICompanyDAO dao=DAOFactory.getDAOFactory(DAOFactory.DERBY1).getCompanyDAO();
		dao.removeAll();
		dao.saveCompany(company);
		
		BisCompanyDetails c2=dao.findCompanyById("0683483-1");
		System.out.println(c2.getBusinessId()+"\t"+c2.getName());
		for(BisAddress address : c2.getAddresses()) {
			System.out.println(address.getStreet());
		}
		
	}
	

}
