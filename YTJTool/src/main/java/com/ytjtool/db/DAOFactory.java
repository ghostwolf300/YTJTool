package com.ytjtool.db;

public abstract class DAOFactory {
	
	public static final int DERBY1=1;
	
	public abstract ICompanyDAO getCompanyDAO();
	
	public static DAOFactory getDAOFactory(int factory) {
		switch(factory) {
		case DERBY1 :
			return new DerbyDAOFactory();
		default :
			return null;
		}
	}
	
}
