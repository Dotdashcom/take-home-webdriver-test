package webtests.Testlayers;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_003_ContextMenu_POM;

public class WT_03_ContextMenu_Test extends WT_BaseClass {
	
	WT_003_ContextMenu_POM cm;
	
	//Constructor
	public WT_03_ContextMenu_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		
	cm= new WT_003_ContextMenu_POM();
	
	driver.get(pr.getProperty("baseurl")+"/context_menu");
	logg.info("****contextmenu url opened****");
	}
	
	@Test
	public void ContextMenuTest() throws InterruptedException {
		
		cm.contextvalidation();
		logg.info("****Right clicked in Squarebox****");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
		logg.info("****Test switched to Alert****");
		
		String  actualtext= alert.getText();
		System.out.println(actualtext);
		String Expectedtext= "You selected a context menu";
		
		Assert.assertEquals(actualtext, Expectedtext);
		logg.info("****Test Passed****");
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
    }
