package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		//Load and register mySQL Driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//Connect to MySQL database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdvancedSelenium", "root", "Ghadai@567");
		
		//Create statement
		Statement state = conn.createStatement();
		
		String query = "insert into Raju(name,id)values('Rudra','type101');";
		
		int data=state.executeUpdate(query);
		
		if(data>=1)
		{
			System.out.println("dataAdded");
		}
		
	}
}
