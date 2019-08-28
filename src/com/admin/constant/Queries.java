package com.admin.constant;

public interface Queries {
	static final String AUTHENTICATION_QUERY = "SELECT * FROM tblemployee WHERE username=? AND password=?";
	static final String SET_DETAILS_QUERY = "INSERT INTO tblemployee (username, password, joiningdate, salary, bonus) VALUES (?, ?, ?, ?, ?)";
	static final String GET_TABLE_DETAILS = "SELECT * FROM tblemployee";
}
