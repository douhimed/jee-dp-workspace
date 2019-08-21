package org.mql.biblio.dao.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class Database {

	private DataSource dataSource;
	private Connection connection;
	private DatabaseMetaData metaData;

	public Database() {
	}

	public Database(DataSource dataSource) {
		setDataSource(dataSource);
		this.connection = dataSource.getConnection();
		try {
			this.metaData = connection.getMetaData();
		} catch (SQLException e) {
			System.out.println("Error in getting meta data of connexion : " + e.getMessage());
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String[][] selectAll(String tableName) {
		String query = "SELECT * FROM " + tableName;
		return executeQuery(query);
	}

	public String[][] selectWithLimit(String tableName, int limit) {
		String query = "SELECT * FROM " + tableName + " LIMIT " + limit;
		return executeQuery(query);
	}

	public String[][] selectLike(String tableName, String key, Object value) {
		String query = "SELECT * FROM " + tableName + " WHERE " + key + " LIKE '%" + value + "%'";
		return executeQuery(query);
	}

	public String[][] selectEqual(String tableName, String key, Object value) {
		String query = "SELECT * FROM " + tableName + " WHERE " + key + " = '" + value + "'";
		return executeQuery(query);
	}

	public String[][] executeQuery(String query) {
		try {
			Statement sql = connection.createStatement();
			ResultSet rs = sql.executeQuery(query);
			ResultSetMetaData rsm = rs.getMetaData();
			int columnCount = rsm.getColumnCount();
			rs.last();
			int rowCount = rs.getRow();
			String[][] data = new String[rowCount + 1][columnCount];
			for (int i = 0; i < columnCount; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}
			rs.beforeFirst();
			int row = 1;
			while (rs.next()) {
				for (int i = 0; i < columnCount; i++) {
					data[row][i] = rs.getString(i + 1);
				}
				row++;
			}
			rs.close();
			return data;
		} catch (Exception e) {
			System.out.println("Went bad at select method : " + e.getMessage());
			return null;
		}
	}

	public int insert(String tableName, Object... data) {
		StringBuffer query = new StringBuffer("INSERT INTO " + delimit(tableName) + " VALUES('" + data[0] +"'");
		for (int i = 1; i < data.length; i++)
			query.append(", '" + data[i] + "'");
		query.append(")");
		return executeStatement(query.toString());
	}

	public int delete(String tabelName, String fieldName, Object value) {
		String query = "DELETE FROM " + tabelName + " WHERE " + fieldName + "= '" + value + "'";
		return executeStatement(query);
	}

	public int update(String tableName, String[][] data) {
		StringBuffer query = new StringBuffer("UPDATE " + delimit(tableName));

		query.append(" SET " + delimit(data[1][0]) + " = '" + data[1][1] + "'");
		for (int i = 2; i < data.length; i++) {
			query.append(", " + delimit(data[i][0]) + " = '" + data[i][1] + "'");
		}
		query.append(" WHERE " + delimit(data[0][0]) + " = '" + data[0][1] + "'");
		return executeStatement(query.toString());
	}

	public int update(String tableName, Object... row) {
		StringBuffer query = new StringBuffer("UPDATE " + delimit(tableName));
		String fields[] = fieldNames(tableName);
		query.append(" SET " + delimit(fields[1]) + " = '" + row[1] + "'");
		for (int i = 2; i < fields.length; i++) {
			query.append(", " + delimit(fields[i]) + " = '" + row[i] + "'");
		}
		query.append(" WHERE " + delimit(fields[0]) + " = '" + row[0] + "'");
		return executeStatement(query.toString());
	}


	private String[] fieldNames(String tableName) {
		try {
			ResultSet rs = metaData.getColumns(null, null, tableName, null);
			Vector<String> fields = new Vector<>();
			while (rs.next()) {
				fields.add(rs.getString(4));
			}
			String t[] = new String[fields.size()];
			fields.toArray(t);
			return t;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

	private int executeStatement(String query) {
		try {
			Statement stm = connection.createStatement();
			stm = connection.createStatement();
			return stm.executeUpdate(query.toString());
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			return 0;
		}
	}

	private String delimit(String tableName) {
		if (tableName.contains(" "))
			return dataSource.startDelimiter() + tableName + dataSource.endtDelimiter();
		return tableName;
	}



}
