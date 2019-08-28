package com.admin.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.admin.constant.Credentials;


public class DatabaseConnection implements Credentials {
	private static DatabaseConnection dbObj;
	Connection conn;
	
	public static DatabaseConnection getDbObj() {
		if (dbObj == null) {
			dbObj = new DatabaseConnection();
		}
		
		return dbObj;
	}

	public Connection getConn()throws SQLException, ClassNotFoundException {
		if (conn == null || conn.isClosed()) {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PWD);
		}
		
		return conn;
	}
}
