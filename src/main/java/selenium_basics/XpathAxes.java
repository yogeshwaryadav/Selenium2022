package selenium_basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(
					"https://www.espncricinfo.com/series"
					+ "/india-in-south-africa-2021-22-1277060/"
					+ "south-africa-vs-india-1st-odi-1277082/full-scorecard");
		System.out.println(getWicketTakerNamwe("Temba Bavuma"));
		System.out.println(getPlayerScoreCard("Aiden Markram"));
		System.out.println(getBowlerScoreCard("Jasprit Bumrah"));
		System.out.println(getBowlerScoreCard("Aiden Markram"));
		
	}
	public static String getWicketTakerNamwe(String player)
	{
		 return driver.findElement(By.xpath("//a[text()='"+player+"']"
		 		+ "/parent::td/following-sibling::td/span")).getText();
	}
	public static List<String> getPlayerScoreCard(String playerName)
	{
		List<String> scorecard=new ArrayList<>();
		List<WebElement> scroreList = driver.findElements(By.xpath("//table[@class='table batsman']//tr//td//a[text()='"+playerName+"']"
		 		+ "/parent::td/following-sibling::td"));
		for(int i=1;i<scroreList.size();i++)
		{
			String text=scroreList.get(i).getText();
			scorecard.add(text);
		}
		return scorecard;
		
	}
	public static List<String> getBowlerScoreCard(String playerName)
	{
		List<String> bowlibgScoreCard=new ArrayList<>();
		List<WebElement> bowlingScroreList = driver.findElements(By.xpath("//table[@class='table bowler']//tr//td//a[text()='"+playerName+"']"
		 		+ "/parent::td/following-sibling::td"));
		for(int i=0;i<bowlingScroreList.size();i++)
		{
			String text=bowlingScroreList.get(i).getText();
			bowlibgScoreCard.add(text);
		}
		return bowlibgScoreCard;
	}
}
