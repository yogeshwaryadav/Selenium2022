package selenium_basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		
//		List<WebElement> languagelink = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
//		for(int i=0;i<languagelink.size();i++)
//		{
//			String lang=languagelink.get(i).getText();
//		}
		By lang=By.xpath("//div[@id='SIvCob']/a");
		clickOnLink(lang, "বাংলা");
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

}
