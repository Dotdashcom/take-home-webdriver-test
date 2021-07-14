package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC05_dragDropObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC05_dragDropTest extends base{
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
		TC05_dragDropObject dd = new TC05_dragDropObject(driver);
		dd.getdragDropLink().click();
		Point box1Location = dd.getbox1().getLocation();
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dd.getbox1(), dd.getbox2()).build().perform();
		Point newBox1Location = dd.getbox1().getLocation();
		AssertJUnit.assertEquals(newBox1Location, box1Location);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
