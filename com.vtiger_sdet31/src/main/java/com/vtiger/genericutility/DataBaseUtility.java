package com.vtiger.genericutility;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	public void connectToDB() throws SQLException{
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	DriverManager.getConnection(IPathConstants.DATABASE_URL, IPathConstants.DB_USERNAME, IPathConstants.DB_PASSWORD);
}
}
