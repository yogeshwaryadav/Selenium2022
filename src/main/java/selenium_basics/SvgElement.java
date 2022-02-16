package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SvgElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(5000);
		
		String xvgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']/*[name()='g']/*[name()='path']";
		List<WebElement> svgEle = driver.findElements(By.xpath(xvgXpath));
		Actions act=new Actions(driver);
		for(WebElement ele:svgEle)
		{
			act.moveToElement(ele).perform();
			Thread.sleep(1000);
			String states=ele.getAttribute("name");
			System.out.println(states);
			if(states.equals("Maryland"))
			{
				act.click(ele).perform();
				break;
			}
		}
	}

}
