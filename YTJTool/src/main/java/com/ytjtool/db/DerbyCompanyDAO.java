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
			System.out.println("error business id: "+company.getBusinessId());
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
				saveLiquidation(liquid,conn);
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
				saveIdChange(idChange,conn);
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
	
	private void saveLiquidation(BisCompanyLiquidation liquidation, Connection conn) throws SQLException{
		String sqlInsertLiquidation="insert into tbl_liquidation (business_id,type_code,description,registration_date,end_date,version,source,language) "
				+ "values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmnt=conn.prepareStatement(sqlInsertLiquidation);
		pstmnt.setString(1, liquidation.getBusinessId());
		pstmnt.setString(2, liquidation.getType());
		pstmnt.setString(3, liquidation.getDescription());
		pstmnt.setDate(4, liquidation.getRegistrationDate());
		pstmnt.setDate(5, liquidation.getEndDate());
		pstmnt.setInt(6, liquidation.getVersion());
		pstmnt.setInt(7, liquidation.getSource());
		pstmnt.setString(8, liquidation.getLanguage());
		pstmnt.executeUpdate();
		pstmnt.close();
	}
	
	private void saveIdChange(BisCompanyBusinessIdChange idChange,Connection conn) throws SQLException{
		String sqlInsertIdChange="insert into tbl_id_change (business_id,change_date,change,old_business_id,new_business_id,language,description,source) "
				+"values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmnt=conn.prepareStatement(sqlInsertIdChange);
		pstmnt.setString(1, idChange.getBusinessId());
		pstmnt.setDate(2, idChange.getChangeDate());
		pstmnt.setString(3, idChange.getChange());
		pstmnt.setString(4, idChange.getOldBusinessId());
		pstmnt.setString(5, idChange.getNewBusinessId());
		pstmnt.setString(6, idChange.getLanguage());
		pstmnt.setString(7,idChange.getDescription());
		pstmnt.setInt(8, idChange.getSource());
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
			company.setAuxiliaryNames(findAuxiliaryNamesById(businessId,conn));
			company.setLiquidations(findLiquidations(businessId,conn));
			company.setBusinessIdChanges(findIdChanges(businessId,conn));
			
			
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
	
	private List<BisCompanyName> findAuxiliaryNamesById(String businessId,Connection conn) throws SQLException{
		
		String sqlFindAuxNames="select business_id,name_order,version,name,registration_date,end_date,source from tbl_auxiliary_name where name_order<>0 and version=1 and business_id=?";
		PreparedStatement pstmnt=conn.prepareStatement(sqlFindAuxNames);
		List<BisCompanyName> auxNames=new ArrayList<BisCompanyName>();
		pstmnt.setString(1, businessId);
		ResultSet rs=null;
		rs=pstmnt.executeQuery();
		while(rs.next()) {
			auxNames.add(createCompanyName(rs));
		}
		
		pstmnt.close();
		if(rs!=null) {
			rs.close();
		}
		
		return auxNames;
	}
	
	private List<BisCompanyLiquidation> findLiquidations(String businessId,Connection conn) throws SQLException{
		String sqlFindLiquidations="select business_id,type_code,description,registration_date,end_date,version,source,language "
				+ "from tbl_liquidation where business_id=? and language='FI'";
		PreparedStatement pstmnt=conn.prepareStatement(sqlFindLiquidations);
		List<BisCompanyLiquidation> liquidations=new ArrayList<BisCompanyLiquidation>();
		pstmnt.setString(1, businessId);
		ResultSet rs=null;
		rs=pstmnt.executeQuery();
		while(rs.next()) {
			liquidations.add(createLiquidation(rs));
		}
		pstmnt.close();
		if(rs!=null) {
			rs.close();
		}
		return liquidations;
	}
	
	private List<BisCompanyBusinessIdChange> findIdChanges(String businessId,Connection conn) throws SQLException{
		String sqlFindIdChanges="select business_id,change_date,change,old_business_id,new_business_id,language,description,source "
				+ "from tbl_id_change where business_id=?";
		PreparedStatement pstmnt=conn.prepareStatement(sqlFindIdChanges);
		List<BisCompanyBusinessIdChange> idChanges=new ArrayList<BisCompanyBusinessIdChange>();
		pstmnt.setString(1, businessId);
		ResultSet rs=null;
		rs=pstmnt.executeQuery();
		while(rs.next()) {
			idChanges.add(createIdChange(rs));
		}
		pstmnt.close();
		if(rs!=null) {
			rs.close();
		}
		return idChanges;
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
	
	private BisCompanyName createCompanyName(ResultSet rs) throws SQLException{
		BisCompanyName name=new BisCompanyName();
		name.setBusinessId(rs.getString("business_id"));
		name.setOrder(rs.getInt("name_order"));
		name.setVersion(rs.getInt("version"));
		name.setSource(rs.getInt("source"));
		name.setName(rs.getString("name"));
		name.setRegistrationDate(rs.getDate("registration_date"));
		name.setEndDate(rs.getDate("end_date"));
		return name;
	}
	
	private BisCompanyLiquidation createLiquidation(ResultSet rs) throws SQLException{
		BisCompanyLiquidation liq=new BisCompanyLiquidation();
		liq.setBusinessId(rs.getString("business_id"));
		liq.setType(rs.getString("type_code"));
		liq.setDescription(rs.getString("description"));
		liq.setRegistrationDate(rs.getDate("registration_date"));
		liq.setEndDate(rs.getDate("end_date"));
		return liq;
	}
	
	private BisCompanyBusinessIdChange createIdChange(ResultSet rs) throws SQLException{
		BisCompanyBusinessIdChange idChange=new BisCompanyBusinessIdChange();
		idChange.setBusinessId(rs.getString("business_id"));
		idChange.setChangeDate(rs.getDate("change_date"));
		idChange.setChange(rs.getString("change"));
		idChange.setOldBusinessId(rs.getString("old_business_id"));
		idChange.setNewBusinessId(rs.getString("new_business_id"));
		idChange.setLanguage(rs.getString("language"));
		idChange.setDescription(rs.getString("description"));
		idChange.setSource(rs.getInt("source"));
		return idChange;
	}

	public List<BisCompanyDetails> findAll() {
		String sqlFindAll="select * from tbl_company_details order by name";
		
		Connection conn=DerbyDAOFactory.createConnection();
		PreparedStatement pstmnt=null;
		List<BisCompanyDetails> companies=null;
		ResultSet rs=null;
		try {
			pstmnt=conn.prepareStatement(sqlFindAll);
			rs=pstmnt.executeQuery();
			while(rs.next()){
				if(companies==null) {
					companies=new ArrayList<BisCompanyDetails>();
				}
				companies.add(createCompanyDetails(rs));
			}
			if(rs!=null) {
				rs.close();
			}
			pstmnt.close();
			
			for(BisCompanyDetails company : companies) {
				company.setAddresses(findAddressesById(company.getBusinessId(),conn));
				company.setAuxiliaryNames(findAuxiliaryNamesById(company.getBusinessId(),conn));
				company.setLiquidations(findLiquidations(company.getBusinessId(),conn));
				company.setBusinessIdChanges(findIdChanges(company.getBusinessId(),conn));
			}
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
		
		return companies;
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

	public void removeCompany(String businessId) {
		Connection conn=DerbyDAOFactory.createConnection();
		PreparedStatement pstmnt=null;
		String sqlRemoveAll="delete from tbl_company_details where business_id=?";
		try {
			pstmnt=conn.prepareStatement(sqlRemoveAll);
			pstmnt.setString(1,businessId);
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
