package Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import Util.BrowserFactory;

public class BaseTest extends BrowserFactory{
	
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
