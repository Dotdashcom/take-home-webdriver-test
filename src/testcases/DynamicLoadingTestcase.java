package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.DynamicControlPage;
import java.Pages.DynamicLoading;
import basePack.BaseClass;

public class DynamicLoadingTestcase extends BaseClass{

	public DynamicLoadingTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	DynamicLoading dynamicLoading;
	
	@BeforeMethod
	@Parameters("dynamicControl")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		dynamicLoading = new DynamicLoading(driver);
		
	}
	
	@Test
	public void toTestDynamicLoding()
	{
		
		dynamicLoading.dynamicLodingFunctionality();
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
