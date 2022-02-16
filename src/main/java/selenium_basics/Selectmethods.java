package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectmethods 
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		WebElement countrySel = driver.findElement(By.id("Form_submitForm_Country"));
//		Select sel=new Select(countrySel);
//		List<WebElement> countryList = sel.getOptions();
//		int listSize=countryList.size();
//		System.out.println(listSize);
//		sel.selectByIndex(6);
//		Thread.sleep(3000);
//		sel.selectByValue("India");
//		Thread.sleep(3000);
//		sel.selectByVisibleText("Bahamas");
		By countrySel=By.id("Form_submitForm_Country");
		doSelectCountry(countrySel, "India");
		
//		for(WebElement e:countryList)
//		{
//			String text=e.getText();
//			System.out.println(text);
//		}

	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static void doSelectCountry(By locator,String value)
	{
		Select sel=new Select(getElement(locator));
		List<WebElement> countryList = sel.getOptions();
		for(WebElement e:countryList)
		{
			String text=e.getText();
//			System.out.println(text);
			if(text.equals(value))
			{
				e.click();
				break;
			}
		}
	}

}
