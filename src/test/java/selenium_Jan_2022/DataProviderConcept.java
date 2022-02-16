package selenium_Jan_2022;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept 
{
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] 
				{{"yogeshwar","yogesh123"},{"admin","admin"},{"Test","Test123"}};
	}
	
	@Test(dataProvider="getData")
	public void loginTest(String un,String pwd)
	{
		System.out.println("userName:"+un+" password:"+pwd);
		
	}

}
