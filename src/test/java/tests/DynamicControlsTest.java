package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.DynamicControlsPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class DynamicControlsTest extends InternetWebBaseTest{
	@Test
	public void testDynamicControls() throws IOException, InterruptedException {
		driver.get(loadProperties().getProperty("BASE_URL")+"dynamic_controls");
		DynamicControlsPage dynamiccontrols=new DynamicControlsPage(driver);
		dynamiccontrols.clickremovebutton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement button=wait.until(ExpectedConditions.elementToBeClickable(dynamiccontrols.addbutton()));
		Assert.assertEquals(dynamiccontrols.getmessage(),"It's gone!");
		dynamiccontrols.clickaddbutton();
		wait.until(ExpectedConditions.elementToBeClickable(dynamiccontrols.removebuttonelement()));		
		Assert.assertEquals(dynamiccontrols.getmessage(),"It's back!");
		dynamiccontrols.clickenablebutton();
		wait.until(ExpectedConditions.elementToBeClickable(dynamiccontrols.disablebutton()));		
		Assert.assertEquals(dynamiccontrols.getmessage(),"It's enabled!");
		dynamiccontrols.clickdisablebutton();
		wait.until(ExpectedConditions.elementToBeClickable(dynamiccontrols.enablebutton()));
		Assert.assertEquals(dynamiccontrols.getmessage(),"It's disabled!");
		Thread.sleep(2000);
		
	}

}
