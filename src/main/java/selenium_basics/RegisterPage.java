package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	public static void main(String[] args) {
		BrowserUtil br=new BrowserUtil();
		WebDriver driver=br.launchBrowser("chrome");
		ElementUtil util=new ElementUtil(driver);
		br.enterUrl("https://demo.opencart.com/index.php?route=account/register");
		
		By firstname=By.name("firstname");
		By lastname=By.id("input-lastname");
		By emailid=By.xpath("//*[@id=\"input-email\"]");
		By telephone=By.cssSelector("#input-telephone");
		By pasword=By.id("input-password");
		By confirmpassword=By.name("confirm");
		By subscribebox=By.name("newsletter");
		By continuebtn=By.className("btn-primary");
		By privacychk=By.name("agree");
		By sucessmsgText=By.xpath("//*[@id=\"content\"]/h1");
		By errormsg=By.xpath("//*[@id=\"account-register\"]/div[1]/i");
		String successmsg="Your Account Has Been Created!";
		
		util.doSendKeys(firstname, "yogesh");
		util.doSendKeys(lastname, "kumar");
		util.doSendKeys(emailid, "yogesh@gmail.com");
		util.doSendKeys(telephone, "8050614295");
		util.doSendKeys(pasword, "admin@123");
		util.doSendKeys(confirmpassword, "admin@123");
		util.doClick(subscribebox);
		util.doClick(privacychk);
		util.doClick(continuebtn);
		String actualtext=util.doGetText(sucessmsgText);
		System.out.println(util.doGetAttribute(firstname, "value"));
		if(actualtext.equals(successmsg))
		{
			System.out.println("Account created successfully");
		}
		else
		{
			if(util.doIsDisplayed(errormsg))
			{
				String err=util.doGetText(errormsg);
				System.out.println(err);
				System.out.println("Account not created ");
			}
		}
		br.closeBrowser();

	}

}
