package webtests.Testlayers;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_007_DynamicControls_POM;

public class WT_07_DynamicControls_Test extends WT_BaseClass {

	WT_007_DynamicControls_POM dControls;
	
	//Constructor
	public WT_07_DynamicControls_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		
		dControls = new WT_007_DynamicControls_POM();
		driver.get(pr.getProperty("baseurl")+"/dynamic_controls");
	}
	
	@Test(priority= 1)
	public void RemoveandAddValidation() {
		dControls.RemoveButton();
		logg.info("****Remove button clicked****");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(dControls.CheckBox()));
		logg.info("****Checkbox disabled****");
		
		Assert.assertTrue(dControls.TextMessage(),"It's gone!");
		logg.info("****Test Passed****");
		
		dControls.AddButton();
		logg.info("****Add Button clicked****");
		
		wait.until(ExpectedConditions.visibilityOf(dControls.CheckBox()));
		logg.info("**** Checkbox enabld****");
		
		Assert.assertTrue(dControls.TextMessage(),"It's back!");
		logg.info("****Test Passed****");
	}
	
	@Test (priority= 2)
	public void EnableAndDisableValidation() throws InterruptedException, IOException {
		dControls.EnableButton();
     logg.info("****Enable button clicked****");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(dControls.TextBox()));
		logg.info("****Textbox enabled****");
		
		if(dControls.TextBox().isEnabled()) {
		  dControls.TypeText();
		Thread.sleep(3000);
			Assert.assertTrue(true);
			logg.info("****Test Passed****");
		}
		else {
			Assert.assertTrue(false);
			logg.info("****Test Failed****");
			captureScreen(driver,"EnableDControl");
		}
		
		dControls.DisableButton();
		
        logg.info("****Disable Button clicked****");
		
        wait.until(ExpectedConditions.visibilityOf(dControls.TextBox()));
		logg.info("**** Checkbox enabld****");
		Thread.sleep(5000);
		
		Assert.assertTrue(dControls.TextMessage(),"It's disabled!");
		logg.info("****Test Passed****");
		}
		
		
	}

