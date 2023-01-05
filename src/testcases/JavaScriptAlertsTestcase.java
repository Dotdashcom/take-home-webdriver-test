package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.JavaScriptAlertsPage;
import basePack.BaseClass;

public class JavaScriptAlertsTestcase extends BaseClass{

	public JavaScriptAlertsTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	JavaScriptAlertsPage js;
	
	@BeforeMethod
	@Parameters("javaScriptAlerts")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		js=new JavaScriptAlertsPage(driver);
		
	}

	@Test
	public void javaScriptAlertsHandling()
	{
		
		js.alertHandling();
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
