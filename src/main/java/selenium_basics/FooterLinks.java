package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		By footers=By.xpath("//ul[@class='footer-nav']//a");
		By downfooterLink=By.xpath("//div[@class=\"footer-nav copyrights-nav hide-in-mobile\"]/a");
//		clickOnLink(footers, "Careers");
		printElementText(downfooterLink);
		clickOnLink(downfooterLink, "Security");
		
	}
	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public static void clickOnLink(By locator,String value)
	{
		List<WebElement> linkList=getElements(locator);
		
		for(WebElement e:linkList)
		{
			String text=e.getText();
			System.out.println(text);
			
			if(text.contains(value))
			{
				e.click();
				break;
			}
		}
		
	}
	public static void printElementText(By locator)
	{
		List<WebElement> eleList = getElements(locator);
		for(WebElement e:eleList)
		{
			String text=e.getText();
			System.out.println(text);
		}
	}

}
