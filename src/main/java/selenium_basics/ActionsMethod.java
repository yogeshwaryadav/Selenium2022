package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsMethod 
{
	static WebDriver driver;

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.fatcow.com/");
		WebElement createSite = driver.findElement(By.linkText("Create a Site"));
		Actions act=new Actions(driver);
		act.moveToElement(createSite).perform();
		List<WebElement> createSiteManu = driver.findElements(By.xpath("//ul[@class='subnav']"));
		for(WebElement e:createSiteManu)
		{
			String text=e.getText();
			System.out.println(text);
		}
		
		

	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static void doMoveToElement(By locator)
	{
		WebElement ele=getElement(locator);
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		
	}

}
