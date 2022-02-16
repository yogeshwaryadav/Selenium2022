package selenium_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {
	/**
	 * ImplicitWait is only applicable for webelements:FE and FES
	 * ImplicitWait is dynamic wait
	 * ImplicitWait is not appplicable for non webelemets:Title,url,Alerts
	 * ImplicitWait is global wait as once declared it is applicable for upcomig webelements
	 * We don't use implicit wait in real time scenarios
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("Email1")).sendKeys("Yogeshwar@gmail.com");
		

	}

}
