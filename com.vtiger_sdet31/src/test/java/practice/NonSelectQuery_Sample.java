package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
import com.vtiger.genericutility.IPathConstants;

public class NonSelectQuery_Sample {

	public static void main(String[] args) throws Throwable {
		Connection con = null;
		int result =0;
		
		Driver driverRef= new Driver();
		/* step 1: To load/ register msql database */
		DriverManager.registerDriver(driverRef);
		
		/* step 2: connect to database  */
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", IPathConstants.DB_USERNAME, IPathConstants.DB_PASSWORD);
		System.out.println("Connection is Done!");
		
		/* step 3: create query statement  */
		Statement stmt = con.createStatement();
		String query = "insert into students_info values('7','Ajay','hindu','B')";
		
		/* step 4: Execute the Query */
		result = stmt.executeUpdate(query);
		
	
		if (result==1) {
			System.out.println("students_info inserted successfully");
		}else {
			System.out.println("students_info is not inserted....!");
		}
			
			/* step 5: close the connection  */
			con.close();
			System.out.println("========db closed=======");

		}
	}


