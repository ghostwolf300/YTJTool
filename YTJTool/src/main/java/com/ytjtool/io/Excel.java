package com.ytjtool.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ytjtool.pojo.BisAddress;
import com.ytjtool.pojo.BisCompanyDetails;
import com.ytjtool.pojo.BisCompanyLiquidation;
import com.ytjtool.pojo.BisCompanyName;

public class Excel implements IFileOperations {
	
	public static final String[] COLUMNS= {"YTJID","Company Name","Alt Names","Street","Postcode","City","C/O","Status"};
	
	public List<String> readYTJIDs(String fileName) {
		Workbook workbook=null;
		List<String> ids=null;
		try {
			workbook=WorkbookFactory.create(new File(fileName));
			Sheet sheet=workbook.getSheetAt(0);
			Iterator<Row> rowIter=sheet.rowIterator();
			ids=new ArrayList<String>();
			while(rowIter.hasNext()) {
				Row row=rowIter.next();
				if(row.getRowNum()>0) {
					ids.add(row.getCell(0).getStringCellValue());
				}
			}
		} 
		catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(workbook!=null) {
				try {
					workbook.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ids;
	}

	public void writeCompanyDetails(List<BisCompanyDetails> companies) {
		
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("Companies");
		
		Font hFont=getHeaderFont(workbook);
		CellStyle hCellStyle=getHeaderCellStyle(workbook,hFont);
		
		Row hRow=sheet.createRow(0);
		
		for(int c=0;c<COLUMNS.length;c++) {
			Cell hcell=hRow.createCell(c);
			hcell.setCellValue(COLUMNS[c]);
			hcell.setCellStyle(hCellStyle);
		}
		
		int r=1;
		Row row=null;
		for(BisCompanyDetails company : companies) {
			row=sheet.createRow(r);
			row.createCell(0).setCellValue(company.getBusinessId());
			row.createCell(1).setCellValue(company.getName());
			String altNames="";
			for(BisCompanyName cname : company.getAuxiliaryNames()) {
				altNames+=cname.getName()+" ";
			}
			row.createCell(2).setCellValue(altNames.trim());
			BisAddress postAddress=null;
			for(BisAddress address : company.getAddresses()) {
				if(address.getType()==2) {
					postAddress=address;
					break;
				}
			}
			if(postAddress!=null) {
				row.createCell(3).setCellValue(postAddress.getStreet());
				row.createCell(4).setCellValue(postAddress.getPostCode());
				row.createCell(5).setCellValue(postAddress.getCity());
				row.createCell(6).setCellValue(postAddress.getCareOf());
			}
			
			if(company.getLiquidations()!=null && company.getLiquidations().size()>0) {
				String status="";
				for(BisCompanyLiquidation liq : company.getLiquidations()) {
					status+=liq+" ";
				}
				row.createCell(7).setCellValue(status.trim());
			}
			
			r++;
		}
		
		for(int c=0;c<COLUMNS.length;c++) {
			sheet.autoSizeColumn(c);
		}
		
		FileOutputStream fout=null;
		try {
			fout = new FileOutputStream("YTJResults.xlsx");
			workbook.write(fout);
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fout!=null) {
				try {
					fout.close();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(workbook!=null) {
				try {
					workbook.close();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}
	
	private Font getHeaderFont(Workbook wb) {
		Font headerFont=wb.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());
		return headerFont;
	}
	
	private CellStyle getHeaderCellStyle(Workbook wb,Font font) {
		CellStyle headerCellStyle=wb.createCellStyle();
		headerCellStyle.setFont(font);
		return headerCellStyle;
	}
	
	private CellStyle getDateCellStyle(Workbook wb) {
		CellStyle dateStyle=wb.createCellStyle();
		dateStyle.setDataFormat(wb.getCreationHelper().createDataFormat().getFormat("dd.MM.yyyy"));
		return dateStyle;
	}

}
