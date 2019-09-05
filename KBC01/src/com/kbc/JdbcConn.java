package com.kbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcConn {
	public static Connection getConnection() {
		Connection con = null;
		try {
			// load oracle driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "284707");
			System.out.println("Connection establish");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static List<Question> getQuestion(){
		List<Question> list= new ArrayList<Question>();
		try {
			Connection con=JdbcConn.getConnection();
			System.out.println("inside jdbc Connection");
			PreparedStatement ps= con.prepareStatement("SELECT * FROM QUESTION");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Question qs=new Question();
				qs.setQuestion(rs.getString(1));
				qs.setAnswer(rs.getString(2));
				qs.setAnswer2(rs.getString(3));
				qs.setAnswer3(rs.getString(4));
				qs.setAnswer4(rs.getString(5));
				list.add(qs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
