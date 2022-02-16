package selenium_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By email=By.name("email");
		By pwd=By.id("input-password");
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement emailFld = wait.until(ExpectedConditions.presenceOfElementLocated(email));
//		emailFld.sendKeys("Yogesh@123");
		getPresenseOfElementLocated(email, 5).sendKeys("Yogeshwar");
		getVisibilityOfElementLocated(pwd, 2).sendKeys("123");

	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static WebElement getPresenseOfElementLocated(By locator,int waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static WebElement getVisibilityOfElementLocated(By locator,int waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
