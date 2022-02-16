package selenium_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil 
{
	
	 
	private WebDriver driver;
	 /**
		 * This method is used to initialize the driver based on browserName
		 * @param browser
		 * @return this return webdriver
		 */
	public WebDriver launchBrowser(String browser)
	{
		switch (browser.toLowerCase()) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\stc\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\stc\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			System.out.println("Please provide the right browser:"+browser);
			break;
		}
		return driver;
	}
	
	public void enterUrl(String url)
	{
		if(url.contains("https://") || url.contains("http://"))
		{
		driver.get(url);
		}
		else
		{
			try {
			throw new Exception("INCORRECT URL MISSING HTTP OR HTTPS");
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	public String PageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public String getCurrentUrl()
	{
		String currentUrl=driver.getCurrentUrl();
		return currentUrl;
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}
	
	public void closeBrowser()
	{
		driver.close();
	}

}
