package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(3000);
		By searchlist=By.xpath("//div[@class='OBMEnb']//div[@class='wM6W7d']/span");
		List<WebElement> suggestionlist = driver.findElements(searchlist);
		System.out.println(suggestionlist.size());
		for(WebElement e:suggestionlist)
		{
			String text=e.getText();
			System.out.println(text);
			if(text.equals("selenium webdriver"))
			{
				e.click();
			}
		}
	}
}
