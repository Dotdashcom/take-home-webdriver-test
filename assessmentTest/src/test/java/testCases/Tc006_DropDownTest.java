package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.DropDownPage;

public class Tc006_DropDownTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/dropdown");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void DropDownTest() throws InterruptedException, IOException {
		DropDownPage dropP = new DropDownPage(driver);
		String optionValue1 = dropP.handlingDropdown("Option 1");
		Assert.assertEquals(optionValue1, "Option 1", "selected option doesnt match");
		logger.info("Selected option is asserted");
		
		Thread.sleep(5000);
		String optionValue2 = dropP.handlingDropdown("Option 2");
		Assert.assertEquals(optionValue2, "Option 2", "selected option doesnt match");
		logger.info("Selected option is asserted");
		bu.captureSrceenshot(driver, "DropDownTest");
	}

}
