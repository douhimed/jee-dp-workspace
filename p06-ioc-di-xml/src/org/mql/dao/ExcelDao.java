package org.mql.dao;

import java.util.Arrays;
import java.util.List;

public class ExcelDao implements IDAO{

	private List<String> data = Arrays.asList("PHP", "JAVA", "C++");

	public String getData(int position) {
		System.out.println("From Excel DB");
		return data.get(position);
	}

	public boolean isExist(String value) {
		return data.contains(value);
	}

}
