package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DynamicLoadingPage;
import Utility.InternetWebBaseTest;

public class DynamicLoadingTest extends InternetWebBaseTest{
	@Test
	public void testDynamicLoading() throws IOException {
			driver.get(loadProperties().getProperty("BASE_URL")+"dynamic_loading/2");
			DynamicLoadingPage loadpage=new DynamicLoadingPage(driver);
			loadpage.startbutton();
			WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
			String text=wait1.until(ExpectedConditions.visibilityOf(loadpage.selectgettext())).getText();
			System.out.println(text);
			Assert.assertEquals(text, "Hello World!","page not load completely");
			
	}

}
