package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.DragAndDropPages;
import java.Pages.LoginSuccessfulPage;
import basePack.BaseClass;

public class DragAndDroptestcases extends BaseClass{

	DragAndDropPages draganddrop;
	public DragAndDroptestcases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	@BeforeMethod
	@Parameters("dragAndDrop")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		draganddrop = new DragAndDropPages(driver);
		
	}
	
	
	
	@Test
	public void dragAndDroppingFunctionality() throws InterruptedException
	{
		Thread.sleep(5000);
		draganddrop.dragAndDropFunctionality();
		
		
		
	}
	
	
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
	
	
}
