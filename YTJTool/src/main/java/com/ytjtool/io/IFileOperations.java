package com.ytjtool.io;

import java.io.File;
import java.util.List;

import com.ytjtool.pojo.BisCompanyDetails;

public interface IFileOperations {
	
	public List<String> readYTJIDs(String fileName);
	public void writeCompanyDetails(List<BisCompanyDetails> companies);
	
}
