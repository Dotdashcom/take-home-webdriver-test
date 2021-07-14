package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC014_hoverObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC014_hoverTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		TC014_hoverObject hob = new TC014_hoverObject(driver);
		Actions action = new Actions(driver);
		hob.getHoverLink().click();
		for(int i =1 ; i<4 ; i++) {
			WebElement target = hob.getHoverImage(i);
			action.moveToElement(target).perform();
			AssertJUnit.assertTrue(hob.gettUserInfo(i).isDisplayed());
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
