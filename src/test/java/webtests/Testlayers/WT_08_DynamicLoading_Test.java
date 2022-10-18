package webtests.Testlayers;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_008_DynamicLoading_POM;

public class WT_08_DynamicLoading_Test extends WT_BaseClass {

	WT_008_DynamicLoading_POM dl;
	
	//Constructor
	public WT_08_DynamicLoading_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		
	    dl= new WT_008_DynamicLoading_POM();
		driver.get(pr.getProperty("baseurl")+"/dynamic_loading/2");
		logg.info("****DynamicLoading url opened****");
	}
	
	@Test
	public void DynamicpageTest() throws IOException {
		
		dl.StartButton();
		logg.info("****Start button clicked****");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(dl.Text()));
		
        if(dl.Text().getText().contains("Hello World!")) {
        	
        	Assert.assertTrue(true);
			logg.info("****Test Passed****");
	}
		else {
			Assert.assertTrue(false);
			logg.info("****Test Failed****");
			captureScreen(driver,"Dynamicloading");
	}
    }
	}

