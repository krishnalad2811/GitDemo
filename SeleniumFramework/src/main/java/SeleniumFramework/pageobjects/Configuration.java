package SeleniumFramework.pageobjects;

public class Configuration 
{
	public static String baseURL = "https://rahulshettyacademy.com/client";
	
	public static String[] productNames = {"Zara Coat 3", "Adidas original", "iphone 13 pro", "Qwerty"};
	
	public static String[] countries = {"India","Canada"};
	
	public static class loginCredentials
	{
		public static String email = "jeetubhaiya@yahoo.com";
		public static String password = "Test1234";
	}
	
	public static class toastMessage
	{
		public static String loginMessage = "Login Successfully";
		public static String orderConfirmationMessage = "Thankyou for the order.";
	}
}
