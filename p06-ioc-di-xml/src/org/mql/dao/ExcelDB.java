package org.mql.dao;

public class ExcelDB implements IDatabase {

	private String tableName = "excel_default_tableName";

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String getTableName() {
		return this.tableName;
	}

}
