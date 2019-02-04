package com.ytjtool.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ytjtool.pojo.BisAddress;
import com.ytjtool.pojo.BisCompanyBusinessIdChange;
import com.ytjtool.pojo.BisCompanyBusinessLine;
import com.ytjtool.pojo.BisCompanyContactDetail;
import com.ytjtool.pojo.BisCompanyDetails;
import com.ytjtool.pojo.BisCompanyForm;
import com.ytjtool.pojo.BisCompanyLanguage;
import com.ytjtool.pojo.BisCompanyLiquidation;
import com.ytjtool.pojo.BisCompanyName;
import com.ytjtool.pojo.BisCompanyRegisteredEntry;
import com.ytjtool.pojo.BisCompanyRegisteredOffice;

public class DerbyCompanyDAO implements ICompanyDAO {

	public void saveCompany(BisCompanyDetails company) {
		Connection conn=DerbyDAOFactory.createConnection();
		try {
			saveSingleCompany(company,conn);
		} 
		catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void saveSingleCompany(BisCompanyDetails company,Connection conn) throws SQLException {
		String sqlInsertCompany="insert into tbl_company_details(business_id,name,company_form,registration_date,details_uri) values(?,?,?,?,?)";
		PreparedStatement pstmnt=conn.prepareStatement(sqlInsertCompany);
		pstmnt.setString(1, company.getBusinessId());
		pstmnt.setString(2, company.getName());
		pstmnt.setString(3, company.getCompanyForm());
		pstmnt.setDate(4, company.getRegistrationDate());
		pstmnt.setString(5, company.getDetailsUri());
		pstmnt.executeUpdate();
		pstmnt.close();
		
		if(company.getNames()!=null) {
			for(BisCompanyName name : company.getNames()) {
				saveName(name,conn);
			}
		}
		
		if(company.getAuxiliaryNames()!=null) {
			for(BisCompanyName auxName : company.getAuxiliaryNames()) {
				saveAuxiliaryName(auxName,conn);
			}
		}
		
		if(company.getAddresses()!=null) {
			for(BisAddress address : company.getAddresses()) {
				saveAddress(address,conn);
			}
		}
		
		if(company.getCompanyForm()!=null) {
			for(BisCompanyForm forms : company.getCompanyForms()) {
				
			}
		}
		
		if(company.getLiquidations()!=null) {
			for(BisCompanyLiquidation liquid : company.getLiquidations()) {
				
			}
		}
		
		if(company.getBusinessLines()!=null) {
			for(BisCompanyBusinessLine bline : company.getBusinessLines()) {
				
			}
		}
		
		if(company.getLanguages()!=null) {
			for(BisCompanyLanguage lang : company.getLanguages()) {
				
			}
		}
		
		if(company.getRegisteredOffices()!=null) {
			for(BisCompanyRegisteredOffice offices : company.getRegisteredOffices()) {
				
			}
		}
		
		if(company.getContactDetails()!=null) {
			for(BisCompanyContactDetail contact : company.getContactDetails()) {
				
			}
		}
		
		if(company.getRegisteredEntries()!=null) {
			for(BisCompanyRegisteredEntry entry : company.getRegisteredEntries()) {
				
			}
		}
		
		if(company.getBusinessIdChanges()!=null) {
			for(BisCompanyBusinessIdChange idChange : company.getBusinessIdChanges()) {
				
			}
		}
	}
	
	private void saveName(BisCompanyName name, Connection conn) throws SQLException {
		String sqlInsertName="insert into tbl_company_name(business_id,name_order,version,name,registration_date,end_date,source) "
				+ "values(?,?,?,?,?,?,?)";
		PreparedStatement pstmnt=conn.prepareStatement(sqlInsertName);
		pstmnt.setString(1,name.getBusinessId());
		pstmnt.setInt(2, name.getOrder());
		pstmnt.setInt(3, name.getVersion());
		pstmnt.setString(4, name.getName());
		pstmnt.setDate(5, name.getRegistrationDate());
		pstmnt.setDate(6, name.getEndDate());
		pstmnt.setInt(7, name.getSource());
		pstmnt.executeUpdate();
		pstmnt.close();
	}
	
	private void saveAuxiliaryName(BisCompanyName name, Connection conn) throws SQLException {
		String sqlInsertName="insert into tbl_auxiliary_name(business_id,name_order,version,name,registration_date,end_date,source) "
				+ "values(?,?,?,?,?,?,?)";
		PreparedStatement pstmnt=conn.prepareStatement(sqlInsertName);
		pstmnt.setString(1,name.getBusinessId());
		pstmnt.setInt(2, name.getOrder());
		pstmnt.setInt(3, name.getVersion());
		pstmnt.setString(4, name.getName());
		pstmnt.setDate(5, name.getRegistrationDate());
		pstmnt.setDate(6, name.getEndDate());
		pstmnt.setInt(7, name.getSource());
		pstmnt.executeUpdate();
		pstmnt.close();
	}
	
	private void saveAddress(BisAddress address,Connection conn) throws SQLException{
		String sqlInsertAddress="insert into tbl_address(business_id,address_type,version,care_of,street,postcode,city,country,language) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmnt=conn.prepareStatement(sqlInsertAddress);
		pstmnt.setString(1, address.getBusinessId());
		pstmnt.setInt(2, address.getType());
		pstmnt.setInt(3, address.getVersion());
		pstmnt.setString(4, address.getCareOf());
		pstmnt.setString(5, address.getStreet());
		pstmnt.setString(6, address.getPostCode());
		pstmnt.setString(7, address.getCity());
		pstmnt.setString(8, address.getCountry());
		pstmnt.setString(9, address.getLanguage());
		pstmnt.executeUpdate();
		pstmnt.close();
		
	}

	public void saveCompanies(List<BisCompanyDetails> companies) {
		Connection conn=DerbyDAOFactory.createConnection();
		try {
			for(BisCompanyDetails company : companies) {
				saveSingleCompany(company,conn);
			}
		}
		catch(SQLException sqle) {
			
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	public BisCompanyDetails findCompanyById(String businessId) {
		String sqlFindCompany="select * from tbl_company_details where business_id=?";
		Connection conn=DerbyDAOFactory.createConnection();
		PreparedStatement pstmnt=null;
		BisCompanyDetails company=null;
		ResultSet rs=null;
		try {
			pstmnt=conn.prepareStatement(sqlFindCompany);
			pstmnt.setString(1, businessId);
			rs=pstmnt.executeQuery();
			while(rs.next()){
				company=createCompanyDetails(rs);
			}
			if(rs!=null) {
				rs.close();
			}
			pstmnt.close();
			
			company.setAddresses(findAddressesById(businessId,conn));
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return company;
	}
	
	private BisCompanyDetails createCompanyDetails(ResultSet rs) throws SQLException {
		BisCompanyDetails company=new BisCompanyDetails();
		company.setBusinessId(rs.getString("business_id"));
		company.setName(rs.getString("name"));
		company.setCompanyForm(rs.getString("company_form"));
		company.setDetailsUri(rs.getString("details_uri"));
		return company;
	}
	
	private List<BisAddress> findAddressesById(String businessId,Connection conn) throws SQLException{
		String sqlFindAddresses="select * from tbl_address where business_id=?";
		List<BisAddress> addresses=new ArrayList<BisAddress>();
		PreparedStatement pstmnt=conn.prepareStatement(sqlFindAddresses);
		ResultSet rs=null;
		pstmnt.setString(1, businessId);
		rs=pstmnt.executeQuery();
		while(rs.next()) {
			addresses.add(createAddress(rs));
		}
		
		pstmnt.close();
		if(rs!=null) {
			rs.close();
		}
		
		return addresses;
	}
	
	private BisAddress createAddress(ResultSet rs) throws SQLException {
		BisAddress address=new BisAddress();
		address.setBusinessId(rs.getString("business_id"));
		address.setType(rs.getInt("address_type"));
		address.setVersion(rs.getInt("version"));
		address.setLanguage(rs.getString("language"));
		address.setCareOf(rs.getString("care_of"));
		address.setStreet(rs.getString("street"));
		address.setCity(rs.getString("city"));
		address.setPostCode(rs.getString("postcode"));
		address.setCountry(rs.getString("country"));
		return address;
	}

	public List<BisCompanyDetails> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAll() {
		Connection conn=DerbyDAOFactory.createConnection();
		PreparedStatement pstmnt=null;
		String sqlRemoveAll="delete from tbl_company_details";
		try {
			pstmnt=conn.prepareStatement(sqlRemoveAll);
			pstmnt.executeUpdate();
			pstmnt.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
