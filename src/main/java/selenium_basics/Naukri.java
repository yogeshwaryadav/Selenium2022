package selenium_basics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Naukri {

	public static void main(String [] args)
	{
		BrowserUtil br=new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		ElementUtil util=new ElementUtil(driver);
		br.enterUrl("https://www.naukri.com/");
		By loginBtn=By.xpath("//div[text()='Login']");
		util.doClick(loginBtn);
		By un=By.xpath("//input[@placeholder='Enter your active Email ID / Username' and @type='text']");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(un));
		
		By pwd=By.cssSelector("input[type='password']");
		By myNaukri=By.xpath("//div[text()='My Naukri']");
		By editProfile=By.linkText("Edit Profile");
		By updateResume=By.id("attachCV");
		Actions act=new Actions(driver);
		
		
		util.doSendKeys(un, "yogeshwaryadav125@gmail.com");
		util.doSendKeys(pwd, "yogesh083@");
		act.click(util.getElement(loginBtn)).perform();
		act.moveToElement(util.getElement(myNaukri)).perform();
		act.click(util.getElement(editProfile)).perform();
		util.doSendKeys(updateResume, "C:\\Users\\stc\\OneDrive\\Desktop\\Yogeshwar_Resume.docx");
	}

}
