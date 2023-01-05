package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.DragAndDropPages;
import java.Pages.DynamicContentPage;
import basePack.BaseClass;

public class DynamicContentTestcase extends BaseClass{

	public DynamicContentTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	DynamicContentPage dynamicContentPage; 
	
	@BeforeMethod
	@Parameters("dynamicContent")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		dynamicContentPage = new DynamicContentPage(driver);

	}
	

	@Test
	public void dynamicContentFunctionality()
	{
		dynamicContentPage.dynamicContent();
	}
	
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
}
