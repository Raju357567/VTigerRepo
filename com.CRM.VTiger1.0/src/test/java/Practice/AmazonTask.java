package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTask {
	public static void main(String[] args)  {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		WebElement allElement = driver.findElement(By.linkText("Mobiles"));
		allElement.click();
		
		WebElement scroll = driver.findElement(By.xpath("//h2[.='Festive prices revealed on top brands']"));
		Actions act=new Actions(driver);
		act.scrollToElement(scroll).perform();
		
		WebElement checkbox = driver.findElement(By.xpath("//span[.='OnePlus']"));
		checkbox.click();
		
		
	}
}
