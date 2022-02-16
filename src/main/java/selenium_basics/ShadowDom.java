package selenium_basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDom {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		// document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
		driver.switchTo().frame("pact");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement tea=(WebElement)js.executeScript(" return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		tea.sendKeys("Masala tea");
	}

}
