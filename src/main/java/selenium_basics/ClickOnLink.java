package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOnLink {

	public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://google.com");
	WebElement SearchBox = driver.findElement(By.name("q"));
	SearchBox.sendKeys("Selenium");
	SearchBox.sendKeys(Keys.ENTER);
	String text1="Selenium";
	List<WebElement> text = driver.findElements(By.xpath("//h3[contains(text(),'"+text1+"')]"));
	for(WebElement ele:text)
	{
		System.out.println(ele.getText());
		if(ele.getText().equals("Selenium Tutorial - javatpoint"))
		{
			ele.click();
			break;
		}
	}
	
	
	

	}

}
