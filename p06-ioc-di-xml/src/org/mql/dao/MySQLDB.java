package org.mql.dao;

public class MySQLDB implements IDatabase {

	private String tableName = "mysql_default_tableName";
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public String getTableName() {
		return this.tableName;
	}

}
