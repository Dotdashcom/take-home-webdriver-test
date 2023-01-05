package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.DragAndDropPages;
import java.Pages.DropdownPage;
import basePack.BaseClass;

public class DropdownTestcase extends BaseClass {

	public DropdownTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	DropdownPage dropdown;
	
	@BeforeMethod
	@Parameters("dropdown")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		dropdown = new DropdownPage(driver);
		
	}
	
	
	
	
	@Test
	public void dropdownFunctionality()
	{
		dropdown.selectOptionsfromDropdown();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
