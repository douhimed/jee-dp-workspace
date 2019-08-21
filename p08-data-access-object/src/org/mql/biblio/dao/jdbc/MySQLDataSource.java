package org.mql.biblio.dao.jdbc;

public class MySQLDataSource extends DataSource {

	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";
	
	public MySQLDataSource(String host, String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, password);
	}

	public MySQLDataSource(String host, String source, String user) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, "");
	}

	public MySQLDataSource(String host, String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, "root", "");
	}

	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, "root", "");
	}

	@Override
	public String getURL() {
		return getBridge() + "//" + getHost() + "/" + getSource();
  	}

	@Override
	public String startDelimiter() {
		return "`";
	}

	@Override
	public String endtDelimiter() {
		return "`";
	}

}
