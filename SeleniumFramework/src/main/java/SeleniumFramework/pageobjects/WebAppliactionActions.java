package SeleniumFramework.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAppliactionActions 
{
	
	 public void InitializeDriver()
	 {
	     Driver.driver = new ChromeDriver();
	     Driver.driver.get(Configuration.baseURL);
	     Driver.driver.manage().window().maximize();
	     Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 }
	 
	 public void closeDriver() {
		Driver.driver.close();
	}
	 
}
	 
		
