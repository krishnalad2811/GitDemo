package FramwworkDesign;

import java.io.ObjectInputFilter.Config;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumFramework.pageobjects.CartLandingPage;
import SeleniumFramework.pageobjects.CheckoutLandingPage;
import SeleniumFramework.pageobjects.Configuration;
import SeleniumFramework.pageobjects.ConfirmationPage;
import SeleniumFramework.pageobjects.Driver;
import SeleniumFramework.pageobjects.LandingPage;
import SeleniumFramework.pageobjects.ProductCatalogue;
import SeleniumFramework.pageobjects.WebAppliactionActions;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebAppliactionActions webActiobObj = new WebAppliactionActions();
		
		webActiobObj.InitializeDriver();
		
		//Login form fill action
		LandingPage lpObj = new LandingPage();		
		ProductCatalogue pcObj = lpObj.LoingFormFill(Configuration.loginCredentials.email, Configuration.loginCredentials.password);
		
		//Creating Product catalogue Obj
		List<WebElement> prodList = pcObj.getProductList();
		CartLandingPage cartLPobj = pcObj.addProductToCart(Configuration.productNames[0]);
		
		//Validating Cart
	
		cartLPobj.navigateToCart();
		Boolean productMatch = cartLPobj.validaeCartPorduct(Configuration.productNames[0]);
		Assert.assertTrue(productMatch);
		Thread.sleep(2000);
		CheckoutLandingPage checkoutPage = cartLPobj.gotoCheckout();
		
		//Product Checkout
		checkoutPage.fillCardDetails();
		checkoutPage.SelectCountry(Configuration.countries[0]);
		Thread.sleep(1000);
		ConfirmationPage confirmMsg = checkoutPage.PlaceOrder();
		
		
		//Order Confirmation
		Assert.assertEquals(confirmMsg.getConfirmationMessage(), Configuration.toastMessage.orderConfirmationMessage.toUpperCase());
		
		webActiobObj.closeDriver();

	}

}
