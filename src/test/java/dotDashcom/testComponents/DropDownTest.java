package dotDashcom.testComponents;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import dotDashcom.pageObjects.DropDownPage;

public class DropDownTest extends BaseTest{
	DropDownPage dropDown;
	
	@Before
	public void setup() throws IOException {
		setup("/dropdown");
		dropDown=new DropDownPage(driver);
	}
	
	@Test
	public void dropDownOption1() {
		dropDown.selectOption1();
		String selectedOption=dropDown.isOptionSelected();
		Assert.assertEquals(selectedOption, "Option 1");
		
		//Selecting Option 2 in same test flow
		dropDown.selectOption2();
		selectedOption=dropDown.isOptionSelected();
		Assert.assertEquals(selectedOption, "Option 2");
	}
	
	@Test
	public void dropDownOption2() {
		dropDown.selectOption2();
		String selectedOption=dropDown.isOptionSelected();
		Assert.assertEquals(selectedOption, "Option 2");
		
	}
}
