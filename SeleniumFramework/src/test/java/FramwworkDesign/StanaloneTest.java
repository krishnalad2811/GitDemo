package FramwworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumFramework.pageobjects.LandingPage;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class StanaloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Invoking chrome driver
		WebDriver driver = new ChromeDriver();
		
		//Calling Landing page class and initalizing driver
	//	LandingPage landingPageObject = new LandingPage(driver);
		
		//Web application url
		driver.get("https://rahulshettyacademy.com/client");
		
		//add Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//maximize windows
		driver.manage().window().maximize();
		
		//Login
		String email = "jeetubhaiya@yahoo.com";
		String password = "Test1234";
		
		//Porduct List
		String[] productName = {"Zara Coat 3", "Adidas original", "iphone 13 pro", "Qwerty"};
		
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		
		//explicit wait until toast message displays
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//List of Products
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
		
		//using Java stream to iterate in List of WebElements
		WebElement prod = productList.stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName[1])).findFirst().orElse(null);
				
		//Click product add to cart
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
				
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		
		//ng-animated
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//click cart button
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		
		
		//Using any match method of java stream
		Boolean Match = cartProducts.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName[1]));
		
		//Asserting the match variable
		Assert.assertTrue(Match);
		
		//Select checkout button
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		/* Task
		 * Add Card details
		 * Enter Email
		 * Enter Country - Auto suggestive drop
		 * Select place order button 
		 * 
		 */
		
		//Insert card details
		
		//1. Select expiry date
		
		//Create Webelement object for dropdown Month
		WebElement month = driver.findElement(By.xpath("(//select[@class='input ddl'])[1]"));
						
		//Create a object of Select class and pass the webElement object
		Select dropdown_Month = new Select(month);
		
		dropdown_Month.selectByVisibleText("11");
		
		
		//Create Webelement object for dropdown Year
		WebElement Year = driver.findElement(By.xpath("(//select[@class='input ddl'])[2]"));
								
		//Create a object of Select class and pass the webElement object
		Select dropdown_Year = new Select(Year);
				
		dropdown_Year.selectByIndex(20);
		
		//2. CVV Code
		driver.findElement(By.cssSelector("body > app-root > app-order > section > div > div > div.col-md-7 > div > div > div.payment__info > div.payment__cc > form > div > div:nth-child(2) > div:nth-child(2) > input")).sendKeys("485");
		
		//3. Name on Card
		driver.findElement(By.cssSelector("body > app-root > app-order > section > div > div > div.col-md-7 > div > div > div.payment__info > div.payment__cc > form > div > div:nth-child(3) > div > input")).sendKeys("Jettu Bhaiya");
		
		//Select Country
		//Selecting Country from Autosuggestive dropdown Menu. using Action class
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2] ")).click();
	
				
				
			//Select Place order button
			driver.findElement(By.cssSelector(".actions a")).click();
		
		
			//Get Order Number
			String OrderNumber = driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText();
			
			System.out.println(OrderNumber);
			
			driver.close();
		
	}
	
	
	
	

}
