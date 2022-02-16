package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassClikAndSendKeys {

	static WebDriver driver;

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		By fn=By.id("input-firstname");
		By ln=By.name("lastname");
		By continueBtn=By.xpath("//input[@value='Continue']");
		doActionsSendKeys(fn, "yogeshwar");
		doActionsSendKeys(ln, "yadav");
		doActionsClick(continueBtn);
		
	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static void doActionsSendKeys(By locator,String value)
	{
		Actions act=new Actions(driver);
		WebElement ele = getElement(locator);
		act.sendKeys(ele, value).perform();
	}
	public static void doActionsClick(By locator)
	{
		Actions act=new Actions(driver);
		WebElement ele = getElement(locator);
		act.click(ele).perform();
	}

}
