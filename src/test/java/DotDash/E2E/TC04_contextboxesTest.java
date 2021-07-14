package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC04_contextMenuObject;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC04_contextboxesTest extends base{
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
		TC04_contextMenuObject co = new TC04_contextMenuObject(driver);
		co.getcontextBoxLink().click();
		Actions actions = new Actions(driver);
		actions.contextClick(co.getContextBox()).perform();
		String actual = driver.switchTo().alert().getText();
		AssertJUnit.assertEquals(actual, "You selected a context menu");
		driver.switchTo().alert().accept();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
