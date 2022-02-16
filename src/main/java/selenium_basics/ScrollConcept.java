package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		By simpleText=By.xpath("//h2[text()='Frictionless, simple, easy']");
		WebElement ele = driver.findElement(simpleText);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//scroll to bottom of the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		
		

	}

}
