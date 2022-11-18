package test;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import helper.Browser;
import helper.PropertiesHandlerConfig;
import helper.WebHelper;



public class TestBaseAssignment {
	
	protected WebHelper helper;
	protected PropertiesHandlerConfig mp;

	@BeforeMethod
	@Parameters({"browser","isHeadless","max_wait"})
	public void setUpDriver(@Optional("CHROME") String browser, Boolean isHeadless, long wait) throws Exception 
	{
		//Initialize WebDriver
		Browser b = Browser.valueOf(browser);
		helper = new WebHelper(b,isHeadless,wait);
		//Initialize property Manager
		mp = new PropertiesHandlerConfig();
	}
	
	@AfterClass
	@Parameters({"close_browser_after_execution"})
	public void tearDownDriver(@Optional("true") boolean closeBrowser) throws Exception {
		if (closeBrowser) {
			helper.closeBrowser();
		}
	}
	
	@AfterMethod
	public void tearDownDriver() throws Exception {
		helper.closeAll();
	}

	protected WebHelper getAutomator(){
		return this.helper;
	}
}
