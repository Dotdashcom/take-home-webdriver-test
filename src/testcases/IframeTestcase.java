package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.FileDownloadPage;
import java.Pages.IframePage;
import basePack.BaseClass;

public class IframeTestcase extends BaseClass{

	public IframeTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	IframePage iframe;
	
	@BeforeMethod
	@Parameters("iframe")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
	}
	
	
	
	
	@Test
	public void iframeTest() throws InterruptedException
	{
		iframe = new IframePage(driver);
		
		iframe.handleIframes();
		
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
