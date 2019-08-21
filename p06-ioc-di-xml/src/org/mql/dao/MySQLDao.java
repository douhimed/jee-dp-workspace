package org.mql.dao;

import java.util.Arrays;
import java.util.List;

public class MySQLDao implements IDAO {

	private List<String> data = Arrays.asList("PHP", "JAVA", "C++");

	private IDatabase db;

	public void setDb(IDatabase db) {
		this.db = db;
		getTableName();
	}

	public void getTableName() {
		System.out.println(this.db.getTableName());
	}

	@Override
	public String getData(int position) {
		System.out.println("From MySQL DB");
		return data.get(position);
	}

	@Override
	public boolean isExist(String value) {
		return data.contains(value);
	}

	public void init() {
		System.out.println("init the MySQLDao bean");
	}

	public void destroy() {
		System.out.println("destroy the MySQLDao bean");
	}

}
