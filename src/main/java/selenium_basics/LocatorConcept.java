package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept 
{
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		//1.
//		driver.findElement(By.id("input-email")).sendKeys("yogesh@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("yogesh@gmail.com");
		 //2.
//		WebElement emailId=driver.findElement(By.id("input-email"));
//		WebElement pwd=driver.findElement(By.id("input-password"));
//		emailId.sendKeys("yogesh@gmail.com");
//		pwd.sendKeys("yogesh@123");
		
		// 3.
		
//		By emailId=By.id("input-email");
//		By pwd=By.id("input-password");
//		driver.findElement(emailId).sendKeys("yogesh@gmail.com");
//		driver.findElement(pwd).sendKeys("yogesh@123");
		// 4. 
		
//		By emailId=By.id("input-email");
//		By pwd=By.id("input-password");
//		
//		getElement(emailId).sendKeys("yogesh@gmail.com");
//		getElement(pwd).sendKeys("yogesh@123");
		
		// 5.
		
//		By emailId=By.id("input-email");
//		By pwd=By.id("input-password");
//		doSendKeys(emailId,"yogesh@gmail.com");
//		doSendKeys(pwd,"yogesh@123");
		
		//6.
		
//		By emailId=By.id("input-email");
//		By pwd=By.id("input-password");
//		
//		ElementUtil eutil=new ElementUtil(driver);
//		eutil.doSendKeys(emailId, "yogesh@gmail.com");
//		eutil.doSendKeys(pwd, "yogesh@123");
		
		//7.
		
		String eId="input-email";
		String password="input-password";
		
//		doSendKeys("id", eId, "yogesh@gmail.com");
//		doSendKeys("id", password, "yogesh123");
		
		ElementUtil eutil=new ElementUtil(driver);
		eutil.doSendKeys("id",eId, "yogesh@gmail.com");
		eutil.doSendKeys("id",password, "yogesh@123");
		
	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static void doSendKeys(By locator,String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	public static void doSendKeys(String locatorType,String locatorValue,String value)
	{
		getElement(getBy(locatorType,locatorValue)).sendKeys(value);;
	}
	
	public static By getBy(String locatorType,String locatorValue)
	{
		By locator=null;
		switch(locatorType)
		{
		case "id":
			locator=By.id(locatorValue);
			break;
			default:
				break;
		}
		return locator;
	
	}
	

}
