package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class JDBCForVTiger {
public static void main(String[] args) throws Throwable {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdvancedSelenium", "root", "Ghadai@567");
	Statement state = con.createStatement();
	
	String query = "insert into Raju(name,id)values('admin','password');";
	
	int data = state.executeUpdate(query);
	
	if(data>=1)
	{
		System.out.println("dataAdded");
	}
	
	ResultSet result = state.executeQuery("select * from Raju where name='admin' and id='password';");
	
	while(result.next())
	{
		String un = result.getString(1);
		System.out.println(un);
		String pass = result.getString(2);
		System.out.println(pass);
		WebDriver driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.get("http://localhost:8888/");
		driver1.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver1.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pass);
		driver1.findElement(By.id("submitButton")).click();
	}
	
	
	
}
}
