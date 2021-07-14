package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC03_CheckboxeObject;import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC03_CheckboxesTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}
	
	//first check all the boxes and assert it
	@Test
	public void testCheckBoxes() throws InterruptedException{
		TC03_CheckboxeObject chk = new TC03_CheckboxeObject(driver);
		/*	Testing Scenario:
		  	checkbox 1 should not be selected
			Checkbox 2 should be selected
		*/
		chk.getcheckboxLink().click();
		Boolean chk1 = chk.getcheckbox1().isSelected();
		Boolean chk2 = chk.getcheckbox2().isSelected();
		
		
		//assert to make sure boxes are properly checked
		if(chk1 == false && chk2 == true) {
			AssertJUnit.assertTrue(true);
		}else {
			AssertJUnit.assertFalse(false);
		}
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
