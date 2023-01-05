package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.ContextMenuPages;
import basePack.BaseClass;

public class ContextMenuTestcase extends BaseClass {

	ContextMenuPages contextMenuPages;
	
	public ContextMenuTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	@Parameters("contextMenuEndPoint")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
	}
	
	
	@Test
	public void toVerifyTheAlert()
	{
		
		contextMenuPages = new ContextMenuPages(driver);
		
		contextMenuPages.clickContextMenu();
		
		
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
