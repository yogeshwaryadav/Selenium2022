package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		//switch to frame based on index
//		driver.switchTo().frame(2);
		//switch to frame by name or id
//		driver.switchTo().frame("main");
		//switch to frame by using webelement
		driver.switchTo().frame(driver.findElement(By.name("main")));
		System.out.println(
				driver.findElement(By.xpath("/html/body/h2")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("bot");

	}

}
