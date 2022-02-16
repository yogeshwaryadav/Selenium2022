package selenium_basics;

public class TestBrowserUtilMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtil br=new BrowserUtil();
		br.launchBrowser("chrome");
		br.enterUrl("www.google.com");
		String expectedTitle="Google";
		String title=br.PageTitle();
		
		if(expectedTitle.equals(title))
		{
			System.out.println("title is correct");
		}
		else
			System.out.println("title is incorrect");
		String url=br.getCurrentUrl();
		br.quitBrowser();

	}

}
