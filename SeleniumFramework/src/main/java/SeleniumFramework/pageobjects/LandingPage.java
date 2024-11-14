package SeleniumFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponent;
import dev.failsafe.internal.util.Assert;

public class LandingPage extends AbstractComponent
{
	//WebDriver driver;
	
	//Initialization of web driver constructor
	public LandingPage() {
		// TODO Auto-generated constructor stub
		super(Driver.driver);
		PageFactory.initElements(Driver.driver, this);
	}

	//Username Field
	@FindBy(id = "userEmail")
	WebElement usernameField;
	
	//Password Field
	@FindBy(id = "userPassword")
	WebElement passwordField;

	//Login button
	@FindBy(id = "login")
	WebElement loginButton;
	
	//Toast Message
	By toastMessage = By.cssSelector("#toast-container");
	
	public ProductCatalogue LoingFormFill(String usrname, String pwd) throws InterruptedException
	 {
		 
		 usernameField.clear();
		 usernameField.sendKeys(usrname);
		 
		 Thread.sleep(2000);
		 
		 passwordField.clear();
		 passwordField.sendKeys(pwd);
		 loginButton.click();	
		 
		 waitForWebElementToAppear(toastMessage);
		 
		 String actualToast = Driver.driver.findElement(toastMessage).getText();
		 System.out.println(actualToast);
		 ProductCatalogue pcObj = new ProductCatalogue();
		 return pcObj;
	 }
	
}
