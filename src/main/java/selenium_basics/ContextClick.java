package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {

	static WebDriver driver;

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		By contextMenu=By.xpath("//span[text()='right click me']");
		contextClick(contextMenu);

	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static void contextClick(By locator)
	{
		Actions act=new Actions(driver);
		act.contextClick(getElement(locator)).perform();
		
	}

}
