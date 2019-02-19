package com.ytjtool.control;

import java.sql.Date;
import java.util.List;

import com.ytjtool.db.DAOFactory;
import com.ytjtool.db.ICompanyDAO;
import com.ytjtool.io.Excel;
import com.ytjtool.io.ExcelIOFactory;
import com.ytjtool.io.IFileOperations;
import com.ytjtool.io.IOFactory;
import com.ytjtool.net.YTJService;
import com.ytjtool.pojo.BisAddress;
import com.ytjtool.pojo.BisCompanyDetails;

public class YTJTool {
	
	private YTJService service=null;
	private ICompanyDAO dao=null;
	
	public YTJTool() {
		service=new YTJService();
		dao=DAOFactory.getDAOFactory(DAOFactory.DERBY1).getCompanyDAO();
	}
	
	public static void main(String[] args) {
		//Bookwell Digital : 2747769-3
		//Aallon auto : 0683483-1
		YTJTool tool=new YTJTool();
		for(String id : tool.importIdsFromExcel()) {
			tool.findCompanyDetails(id);
		}
		tool.exportToExcel();

	}
	
	private void findCompanyDetails(String businessId) {
		int retryCount=0;
		BisCompanyDetails company=service.getCompanyDetails(businessId);
		if(company!=null) {
			System.out.println(businessId+" "+company.getName());
			dao.removeCompany(businessId);
			dao.saveCompany(company);
		}
		else {
			System.out.println("Business Id "+businessId+" not found!");
			/*while(retryCount<3) {
				System.out.println("Waiting 2s and then retry... (retry count: "+retryCount+")");
				try {
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Trying again...");
				company=service.getCompanyDetails(businessId);
				if(company!=null) {
					System.out.println(businessId+" "+company.getName());
					dao.removeCompany(businessId);
					dao.saveCompany(company);
				}
				retryCount++;
			}*/
		}
		
		//BisCompanyDetails c2=dao.findCompanyById(businessId);
		//System.out.println(c2.getBusinessId()+"\t"+c2.getName());
		
	}
	
	private void exportToExcel() {
		List<BisCompanyDetails> companies=dao.findAll();
		IOFactory factory=IOFactory.getIOFactory(IOFactory.IO_EXCEL);
		IFileOperations excel=factory.getIOType();
		excel.writeCompanyDetails(companies);
		
	}
	
	private List<String> importIdsFromExcel(){
		IOFactory factory=IOFactory.getIOFactory(IOFactory.IO_EXCEL);
		IFileOperations excel=factory.getIOType();
		List<String> ids=excel.readYTJIDs("YTJID lista.xlsx");
		return ids;
	}
	

}
