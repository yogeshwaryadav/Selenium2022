package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelector {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		driver.findElement(By.cssSelector("input#input-firstname")).sendKeys("Yogeshwar");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Yadav");
		driver.findElement(By.cssSelector("input[name='email']#input-email.form-control")).sendKeys("Test@123");
		driver.findElement(By.cssSelector("[type='submit']")).click();

	}

}
