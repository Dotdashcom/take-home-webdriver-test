package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class CheckboxesTest extends TestBase{
	
	public CheckboxesTest() throws IOException {
		super();	
	}
	
	@Test
	public void verifyCheckBoxes()
	{
		driver.get(urlvalues.url_checkboxes);
		
		//testing for checkbox selection in the condition and return true if checkbox selected 
		if(data.checkbox1.isSelected()==false & data.checkbox2.isSelected()==true)
		{
			//checkbox 1 is selected
			data.checkbox1.click();
			
			//checkbox 2 is selected 
			data.checkbox2.click();
			Assert.assertTrue(data.checkbox1.isSelected());
			System.out.println("CheckBox 1 get selected and CheckBox 2 get unselected ");
		}
	}
}
