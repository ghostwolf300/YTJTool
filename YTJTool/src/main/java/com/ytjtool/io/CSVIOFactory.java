package com.ytjtool.io;

public class CSVIOFactory extends IOFactory {

	@Override
	public IFileOperations getIOType() {
		return new CSV();
	}

}
