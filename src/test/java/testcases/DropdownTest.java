package testcases;

import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class DropdownTest extends TestBase{
	
	public DropdownTest() throws IOException {
		super();	
	}
	
	@Test
	public void verifyDropDown() throws InterruptedException
	{	
		driver.get(urlvalues.url_dropdown);
		
		//creating the object of Select class 
		Select s = new Select(data.dropdownmenu);
		
		//select the dropdown value using index method 
		s.selectByIndex(1);
		Thread.sleep(2000);
		String first =  data.dropdowntext.getText();
		String option1 = "Option 1";
		Assert.assertEquals(first, option1);
		System.out.println("Option 1 is selected");
		
		s.selectByIndex(2);
		Thread.sleep(2000);
		String second =  data.dropdowntext.getText();
		String option2 = "Option 2";
		Assert.assertEquals(second, option2);
		System.out.println("Option 2 is selected");
	}
}
