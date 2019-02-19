package com.ytjtool.io;

public abstract class IOFactory {
	
	public static final int IO_EXCEL=1;
	public static final int IO_CSV=2;
	
	public static IOFactory getIOFactory(int type) {
		switch(type) {
		case IO_EXCEL :
			return new ExcelIOFactory();
		case IO_CSV :
			return null;
		default :
			return null;
		}
	}
	
	public abstract IFileOperations getIOType();
	
}
