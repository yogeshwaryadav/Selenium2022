package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSelect {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
//		List<WebElement> mulitSelectList = driver.findElements(By.xpath
//				("//span[@class='comboTreeItemTitle']"));
//		
//		Thread.sleep(3000);
//		
//		System.out.println(mulitSelectList.size());
//		for(WebElement e:mulitSelectList)
//		{
//			String text=e.getText();
//			System.out.println(text);
//		}

		By multiSel = By.xpath("//span[@class='comboTreeItemTitle']");
		// TC:Single select
//		selectChoice(multiSel, "choice 1");	
		
//		//TC:Multi select
		selectChoice(multiSel,"choice 1","choice 2","choice 8");
		// TC:Select All
//		selectChoice(multiSel, "All");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectChoice(By locator, String... choice) throws InterruptedException {
		List<WebElement> mulitSelectList = driver.findElements(locator);
		boolean flag=false;
		if (!choice[0].equalsIgnoreCase("all")) {
			for (WebElement e : mulitSelectList) {
				String text = e.getText();
					for (int i = 0; i < choice.length; i++) {
						if (text.equals(choice[i])) 
						{
							flag=true;
							e.click();
							break;
						}
						else
						{
							flag=false;
							choice[0]=choice[i];
						}
					}
				}
			}
		else {
			try {
				for (WebElement e : mulitSelectList) {
					flag=true;
					e.click();
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("all choices are over");
			}

		}
		if(flag==false)
		{
			System.out.println("choice is not availabe "+choice[0]);
		}

	}

}
