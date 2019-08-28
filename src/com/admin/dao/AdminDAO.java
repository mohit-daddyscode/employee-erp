package com.admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.admin.constant.Queries;
import com.admin.model.UserPOJO;
import com.admin.utility.CloseConnection;
import com.admin.utility.DatabaseConnection;

public class AdminDAO extends CloseConnection implements Queries {
	//close connection pending 
	public boolean getAuthentication(String username, String password) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = DatabaseConnection.getDbObj().getConn().prepareStatement(AUTHENTICATION_QUERY);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			close(rs, ps);
			
			return true;
		}
		
		return false;
	}
	
	public void setEmployee(UserPOJO user) throws SQLException, ClassNotFoundException, ParseException {
		int bonus = computeBonus(user); // calculating bonus
		user.setBonus(bonus); // setting the bonus value for user
		
		PreparedStatement ps = DatabaseConnection.getDbObj().getConn().prepareStatement(SET_DETAILS_QUERY);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getJoiningdate());
		ps.setInt(4, user.getSalary());
		ps.setInt(5, user.getBonus());
		
		ps.executeUpdate(); // inserting the above values in database
	}
	
	public int computeBonus(UserPOJO user) throws ParseException {
		int monthsAfterJoining, bonus = 0;
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String today = format.format(System.currentTimeMillis());
		String joiningdate = user.getJoiningdate();
		
		Date todayDate = format.parse(today);
		Date joinDate = format.parse(joiningdate);
		
		long differenceInMillis = Math.abs(todayDate.getTime() - joinDate.getTime());
		long days = TimeUnit.DAYS.convert(differenceInMillis, TimeUnit.MILLISECONDS);
		System.out.println(days);
		
		if (days >= 365) {
			user.setBonus(user.getSalary()); // assigning the whole salary as bonus
			bonus = user.getBonus();
			System.out.println(bonus);
		} else {
			monthsAfterJoining = ((int)days / 30) - 1; // removing 1 month because the month you joined in does not count
			
			bonus = (monthsAfterJoining * user.getSalary()) / 12;
		}
			
		return bonus;
	}
	
	public ArrayList<UserPOJO> getDetails() throws SQLException, ClassNotFoundException {
		ArrayList<UserPOJO> employeeDetails = new ArrayList<UserPOJO>();
		
		PreparedStatement ps = DatabaseConnection.getDbObj().getConn().prepareStatement(GET_TABLE_DETAILS);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			UserPOJO users = new UserPOJO();
			users.setUsername(rs.getString("username"));
			users.setJoiningdate(rs.getString("joiningdate"));
			users.setSalary(rs.getInt("salary"));
			users.setBonus(rs.getInt("bonus"));
			
			employeeDetails.add(users);
		}
		
		return employeeDetails;
	}
}
