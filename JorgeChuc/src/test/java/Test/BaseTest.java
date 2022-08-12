package Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import Util.MainClass;

public class BaseTest extends MainClass{
	
	@Before
	public void StartBrowser()
    {
		startBrowser();
	}
	
	public static WebDriver getDriver() 
	{
		return GetDriver();
	}	

    @After		
    public void CloseBrowser() 
    {	
    	closeBrowser();
    }
	

}
