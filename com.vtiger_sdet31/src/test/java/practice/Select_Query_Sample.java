package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
import com.vtiger.genericutility.IPathConstants;


//was to work on JDBC
public class Select_Query_Sample {

	public static void main(String[] args) throws Throwable  {
		Connection con = null;
		try {
		Driver driverRef= new Driver();
		/* step 1: To load/ register msql database */
		DriverManager.registerDriver(driverRef);
		
		/* step 2: connect to database  */
		con = DriverManager.getConnection(IPathConstants.DATABASE_URL, IPathConstants.DB_USERNAME, IPathConstants.DB_PASSWORD);
		System.out.println("Connection is Done!");
		
		/* step 3: create query statement  */
		Statement stmt = con.createStatement();
		String query = "select * from students_info";
		
		/* step 4: Execute the Query */
		ResultSet resultset = stmt.executeQuery(query);
		while (resultset.next()) {
			System.out.println(resultset.getString(1)+resultset.getString(2)+resultset.getString(1)+
					resultset.getString(4)+resultset.getString(5)+resultset.getString(6));
			}
		}catch(Exception e){
		}finally {
		/* step 5: close the connection  */
			con.close();
			System.out.println("========db closed=======");
		}
		
	}

}
