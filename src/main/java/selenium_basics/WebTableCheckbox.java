package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckbox {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.findElement(By.xpath("//a[text()='Joe.Root']"
				+ "/parent::td/preceding-sibling::td/"
				+ "input[@id='ohrmList_chkSelectRecord_21']")).click();
	}

}
