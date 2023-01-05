package testcases;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.CheckBoxPage;
import basePack.BaseClass;

public class CheckBoxTestcase extends BaseClass{
	
	CheckBoxPage checkbox;

	public CheckBoxTestcase() throws IOException {
		super();
		
	}

	//<class name="Testcases.LoginFailureTestcases"/>
   // <class name="Testcases.LoginSuccesfullTestcase"/>
	
	@BeforeMethod
	@Parameters("checkboxEndPoint")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		
	}
	
	@Test

	public void toCheckAndUncheck()
	{
		checkbox = new CheckBoxPage(driver);
		checkbox.toCheck();
		
		
	}
	
	@AfterMethod
	public void toTearDown()
	{
		driver.quit();
	}
	
}
