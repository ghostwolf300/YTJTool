package com.ytjtool.io;

public class ExcelIOFactory extends IOFactory {

	@Override
	public IFileOperations getIOType() {
		return new Excel();
	}

}
