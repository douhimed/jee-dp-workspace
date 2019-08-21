package org.mql.biblio.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DataSource {

	private String driver;
	private String bridge;
	private String host;
	private String source;
	private String user;
	private String password;
	
	public DataSource(String driver, String bridge, String host, String source, String user, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.host = host;
		this.source = source;
		this.user = user;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			String url = getURL();
			Connection conn = DriverManager.getConnection(url, this.user, this.password);
			System.out.println("Connxion bien établie");
			return conn;
		} catch (Exception e) {
			System.out.println("Error in creating connexion : " + e.getMessage());
			return null;
		}
	}

	abstract public String getURL();
	abstract public String startDelimiter();
	abstract public String endtDelimiter();

}
