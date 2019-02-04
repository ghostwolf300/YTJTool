package com.ytjtool.db;

import java.util.List;

import com.ytjtool.pojo.BisCompanyDetails;

public interface ICompanyDAO {
	
	public void saveCompany(BisCompanyDetails company);
	public void saveCompanies(List<BisCompanyDetails> companies);
	public BisCompanyDetails findCompanyById(String businessId);
	public List<BisCompanyDetails> findAll();
	public void removeAll();
	
}
