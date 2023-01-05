package testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.JavaScriptAlertsPage;
import java.Pages.JavaScriptErrorPage;
import basePack.BaseClass;

public class JavaScriptErrorTestcase extends BaseClass{

	public JavaScriptErrorTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	JavaScriptErrorPage jsError;
	
	@BeforeMethod
	@Parameters("javaScriptError")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		jsError=new JavaScriptErrorPage(driver);
		
	}
	
	
	@Test
	public void javaScriptError()
	{
		jsError.testJavaScriptError();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
