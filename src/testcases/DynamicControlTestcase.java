package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.DragAndDropPages;
import java.Pages.DynamicControlPage;
import basePack.BaseClass;

public class DynamicControlTestcase extends BaseClass{

	public DynamicControlTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	DynamicControlPage dynamicControl;
	
	@BeforeMethod
	@Parameters("dynamicControl")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		dynamicControl = new DynamicControlPage(driver);
		
	}
	
	
	
	@Test
	public void dynamicControls() throws InterruptedException
	{
		dynamicControl.handlingDynamicContent();	
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
