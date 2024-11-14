package SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFramework.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent
{
	//WebDriver driver;
	
	//Initialization of web driver constructor
	public ProductCatalogue() {
		super(Driver.driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(Driver.driver, this); //Exclusive to driver.findElements
	}


	//Product List
	@FindBy(css = ".card")
	List<WebElement> productList;
	
	//Product variable
	By productsWebElement = By.cssSelector(".card");
	
	//Toast Message
	By toastMessage = By.cssSelector("#toast-container");
	
	//Animation 
	@FindBy(css = ".ng-animating")
	WebElement catalogueAnimation;
	
	//Add to cart
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	public  List<WebElement> getProductList()
	{
		waitForWebElementToAppear(productsWebElement);
		return productList;
	}
	
	/*
	 * Find product using product name
	 */	
	
	public WebElement getProductByName(String prodName)
	{
		WebElement prod = getProductList().stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodName)).findFirst().orElse(null);
		
		return prod;
	}
	
	public CartLandingPage addProductToCart(String productName) throws InterruptedException
	{
		WebElement cartProd = getProductByName(productName);
		cartProd.findElement(addToCart).click();
		waitForWebElementToAppear(toastMessage);
		Thread.sleep(2000);
		 String actualToast = Driver.driver.findElement(toastMessage).getText();
		 System.out.println(actualToast);
		waitForWebElementToDisappear(catalogueAnimation);
		CartLandingPage cartLPobj = new CartLandingPage();
		return cartLPobj;
	}
	
	
	  
	
	
}
