package selenium_basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
//		List<WebElement> linklist=driver.findElements(By.tagName("a"));
//		int totallinks=linklist.size();
//		System.out.println(totallinks);
//		int c=0;
//		for(WebElement e:linklist)
//		{
//			String text=e.getText();
//			if(!text.isEmpty()) {
//			System.out.println(c+":"+text);
//			}
//			System.out.println(e.getAttribute("href"));
//			c++;
//		}
		
		By links=By.tagName("a");
		By img=By.tagName("img");
		System.out.println(getElementCount(img));
		System.out.println(getElementCount(links));
		
		if(getElementTextlist(links).contains("Registry"))
		{
			System.out.println("Registry link is present");
		}
		
		System.out.println(getElementsAttributeList(img, "src"));
		System.out.println(getElementsAttributeList(img, "alt"));
		System.out.println(getElementsAttributeList(img, "href"));

	}
	
	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	public static int getElementCount(By locator)
	{
		return getElements(locator).size();
		
	}
	/**
	 * This method returns the element's attribute value
	 * @param locator
	 * @param attrName
	 * @return
	 */
	public static List<String> getElementsAttributeList(By locator,String attrName)
	{
		List<WebElement> elelist=getElements(locator);
		List<String> eleAttrlist=new ArrayList<String>();
		for(WebElement e:elelist)
		{
			String attrValue=e.getAttribute(attrName);
			eleAttrlist.add(attrValue);
		}
		return eleAttrlist;
		
	}
	/**
	 * This method returns the list of element's text
	 * @param locator
	 * @return
	 */
	public static List<String> getElementTextlist(By locator)
	{
		List<WebElement> elelist=getElements(locator);
		List<String> eleTextlist=new ArrayList<String>();
		for(WebElement e:elelist)
		{
			String text=e.getText();
			if(!text.isEmpty())
			{
			eleTextlist.add(text);
			}
		}
		return eleTextlist;
	}

}
