package SeleniumFramework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	public ConfirmationPage() {
		super(Driver.driver);
		PageFactory.initElements(Driver.driver, this); //Exclusive to driver.findElements
	}
	
	@FindBy(css = "label[class='ng-star-inserted']")
	WebElement orderNumber;
	
	@FindBy(css=".hero-primary")
	WebElement orderConfirmMessage;
	
	public String getConfirmationMessage()
	{
		String ordNum = orderNumber.getText();
		System.out.println(ordNum);
		
		String cfmMsg = orderConfirmMessage.getText();
		return cfmMsg;
	}

}
