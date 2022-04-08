package com.storeManagement;

import java.sql.Connection;
import java.sql.DriverManager;

//import com.mysql.cj.jdbc.Driver;

public class DBConnection {

	static Connection con;

	public static Connection createConnection() {
		try {
			// Loading the driver...
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Getting the connection...
			String url = "jdbc:mysql://localhost:3306/store_manage";
			String user = "root";
			String pass = "root";
			con = DriverManager.getConnection(url, user, pass);

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Connection cannot be established");
		}

		return con;
	}
}
