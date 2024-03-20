package com.shop.demoShop.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=webBH1;user=sa;password=123123");
			System.out.println("Thanh Cong");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}

