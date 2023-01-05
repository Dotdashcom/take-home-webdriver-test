package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.JavaScriptErrorPage;
import java.Pages.NewWindowPages;
import basePack.BaseClass;

public class NewWindowsTestcase extends BaseClass {

	public NewWindowsTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	NewWindowPages newWindow;
	@BeforeMethod
	@Parameters("windows")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		newWindow=new NewWindowPages(driver);
		
	}
	
	
	
	@Test
	public void toVerifyNewWindowOpened() throws InterruptedException
	{
		newWindow.openANewWindow();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
