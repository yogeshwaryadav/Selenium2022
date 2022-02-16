package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
//		System.out.println(getCompanyName("Maria Anders"));
//		System.out.println(getCountry("Maria Anders"));
//		System.out.println(getRowCount());
//		System.out.println(getColumnCount());
		printWebtable();
		
		

	}
	public static String getCompanyName(String name)
	{
		return driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td")).getText();
	}
	
	public static String getCountry(String name)
	{
		return driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td")).getText();
	}
	
	public static int getRowCount()
	{
		List<WebElement> rowsList = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rows = rowsList.size();
		return rows;
	}
	
	public static int getColumnCount()
	{
		List<WebElement> columnList = driver.findElements(By.xpath("//table[@id='customers']//tr/th"));
		int column = columnList.size();
		return column;
	}
	
	public static void printWebtable()
	{
		
		for(int col=1;col<=getColumnCount();col++)
		{
			for(int rows=2;rows<=getRowCount();rows++)
			{
				String before_xpath="//*[@id=\"customers\"]/tbody/tr[";
				String after_xpath="]/td[";
				String xpath=before_xpath+rows+after_xpath+col+"]";
				String text=driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text+ " ");
			}
			System.out.println();
		}
		
	}

}
