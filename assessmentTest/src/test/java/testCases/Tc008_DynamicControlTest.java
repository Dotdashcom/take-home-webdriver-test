package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.DynamicControlPage;

public class Tc008_DynamicControlTest extends baseutils{
	baseutils bu =  new baseutils();
	
	@BeforeClass
	public void setup() {
		bu.initBrowser("/dynamic_controls");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
		
	@Test
	public void DynamicControlRemoveAdd() throws IOException, InterruptedException {
		DynamicControlPage dycp = new DynamicControlPage(driver);
		//for remove
		String Message = dycp.DynamicControlRemove();
		Assert.assertEquals(Message, "It's gone!");
		logger.info("Message displayed : "+Message);
		//for add
		String Message1 = dycp.DynamicControlAdd();
		Assert.assertEquals(Message1, "It's back!");
		logger.info("Message displayed : "+Message1);
		bu.captureSrceenshot(driver, "DynamicControlRemoveAdd");
		
	
		Thread.sleep(3000);
		//for enable/disable
		String Message2 = dycp.DynamicControlEnable();
		Assert.assertEquals(Message2, "It's enabled!");
		logger.info("Message displayed : "+Message2);
		//for DISABLE
		String Message3 = dycp.DynamicControldisable();
		Assert.assertEquals(Message3, "It's disabled!");
		logger.info("Message displayed : "+Message3);
		bu.captureSrceenshot(driver, "DynamicControlEnableDisable");
		
	}

}
