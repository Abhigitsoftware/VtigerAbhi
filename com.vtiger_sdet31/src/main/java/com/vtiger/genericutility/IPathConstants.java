package com.vtiger.genericutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public interface IPathConstants {
	public String PROPERTYFILE_PATH="./src/main/resources/CommonData/credentials.properties";
	public String EXCEL_PATH="./src/main/resources/TestData/testData.xlsx";
		
	public String DATABASE_URL= "jdbc:mysql://localhost:3306/projects";
	public String DB_USERNAME="root";
	public String DB_PASSWORD="root";
	
	public int ITO=20;
	public int ETO=20;

}
