package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC06_dropdownObject;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC06_dropdownTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}
	
	//first check all the boxes and assert it
	@Test
	public void testCheckBoxes(){
		/*	Testing Scenario:
	  		Test right clicks on the context menu and assert the text.
		*/
		TC06_dropdownObject ddo = new TC06_dropdownObject(driver);
		ddo.getdropdownLink().click();
		Select select = new Select(ddo.getdropdown());
		
		select.selectByVisibleText("Option 1");
		if(ddo.getoptionA().isSelected()) {
			AssertJUnit.assertTrue(true);
		}else {
			AssertJUnit.assertTrue(false);
		}
		
		select.selectByVisibleText("Option 2");
		if(ddo.getoptionB().isSelected()) {
			AssertJUnit.assertTrue(true);
		}else {
			AssertJUnit.assertTrue(false);
		}
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
