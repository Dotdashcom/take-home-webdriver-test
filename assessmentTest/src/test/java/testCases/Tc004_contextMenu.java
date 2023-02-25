package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.baseutils;
import pageObjects.contextMenuPage;

public class Tc004_contextMenu extends baseutils{
	
	baseutils bu = new baseutils();
	
	@BeforeClass
	public void setup() {
		//initialize browser
		bu.initBrowser("/context_menu");
	}
	
	//@AfterClass
	public void teardown() {
		//close the browser
		driver.quit();
	}
	
	@Test
	public void contextMenu() throws IOException, InterruptedException {
		contextMenuPage cmp = new contextMenuPage(driver);
		cmp.rightClickOnBox();
		bu.captureSrceenshot(driver, "contextMenu");
		String AlertMsg = cmp.handlingAlert();
		Assert.assertEquals(AlertMsg, "You selected a context menu", "Alert message didn't match");
		logger.info("Assertion pass: message matches.");
			
		
		
	}

}
