package SeleniumFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SeleniumFramework.AbstractComponents.AbstractComponent;

public class CheckoutLandingPage extends AbstractComponent {
	
	public CheckoutLandingPage() {
		super(Driver.driver);
		PageFactory.initElements(Driver.driver, this); //Exclusive to driver.findElements
	}
	
	//Expiry Date Month
	@FindBy(xpath = "(//select[@class='input ddl'])[1]")
	WebElement monthField;
	
	//Expiry Date Year
	@FindBy(xpath = "(//select[@class='input ddl'])[2]")
	WebElement yearField;
	
	
	//Card CVV Code
	@FindBy(css = "body > app-root > app-order > section > div > div > div.col-md-7 > div > div > div.payment__info > div.payment__cc > form > div > div:nth-child(2) > div:nth-child(2) > input")
	WebElement cvvCodeField;
	 
	//Name on Card
	@FindBy(css ="body > app-root > app-order > section > div > div > div.col-md-7 > div > div > div.payment__info > div.payment__cc > form > div > div:nth-child(3) > div > input")
	WebElement nameOnCardField;
	
	//Country Field
	@FindBy(css = "[placeholder='Select Country']")
	WebElement countrySelectionField;
	
	//country options
	By coutryOption = By.cssSelector(".ta-results");
	
	//Select country from options
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;

	//Place Order 
	@FindBy(css = ".actions a")
	WebElement placeOrderButton;
	
	@FindBy(css = "label[class='ng-star-inserted']")
	WebElement orderNumber;
	
	@FindBy(css=".hero-primary")
	WebElement orderConfirmMessage;
	

	
	
	
	public void fillCardDetails()
	{
		//Create a object of Select class and pass the webElement object
		Select select_Month = new Select(monthField);
		select_Month.selectByVisibleText("11");
		
		//Create a object of Select class and pass the webElement object
		Select select_Year = new Select(yearField);
		select_Year.selectByIndex(26);
		
		cvvCodeField.sendKeys("111");
		nameOnCardField.sendKeys("Jeetu Bhaiya");
		
	}
	
	public void SelectCountry(String country) 
	{
		Actions a = new Actions(Driver.driver);
		a.sendKeys(countrySelectionField, country).build().perform();
		waitForWebElementToAppear(coutryOption);	
		selectCountry.click();
	}
	
	public ConfirmationPage PlaceOrder() 
	{		
		placeOrderButton.click();
		ConfirmationPage cfmPage = new ConfirmationPage();
		return cfmPage;	
	}
	
			

}
