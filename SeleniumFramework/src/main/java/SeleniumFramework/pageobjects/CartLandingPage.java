package SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumFramework.AbstractComponents.AbstractComponent;

public class CartLandingPage extends AbstractComponent
{
	public CartLandingPage()  {
		// TODO Auto-generated constructor stub
		super(Driver.driver);
		PageFactory.initElements(Driver.driver, this);
	}
	
		//Checkout button
		@FindBy(css = ".totalRow button")
		WebElement checkoutButton;
		
		//Cart List
		@FindBy(xpath = "//div[@class='cartSection']/h3")
		List<WebElement> cartProductList;
		
		public Boolean validaeCartPorduct(String prodductName) 
		{			
		
			//Using any match method of java stream
			Boolean Match = cartProductList.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(prodductName));
			return Match;
		
		}
		
		public CheckoutLandingPage gotoCheckout()
		{
			checkoutButton.click();
			CheckoutLandingPage checkoutPage = new CheckoutLandingPage();
			return checkoutPage;
		}
		
}
