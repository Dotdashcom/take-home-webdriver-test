package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.TC013_iFrameObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC013_iFrameTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		TC013_iFrameObject ifo = new TC013_iFrameObject(driver);
		String text = "Hello World!";
		ifo.getIFrameLink().click();
		ifo.getFrameLink().click();
		//Thread.sleep(3000);
		driver.switchTo().frame(ifo.getFrameId());
		ifo.getFrameBody().clear();
		ifo.getFrameBody().sendKeys(text);
		String actualText = ifo.getFrameBody().getText();
		AssertJUnit.assertEquals(actualText, text);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
