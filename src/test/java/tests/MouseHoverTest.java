package tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import PageObjects.MouseHoverPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class MouseHoverTest extends InternetWebBaseTest{
	@Test
	public void testMouseHover() throws IOException, InterruptedException {
		driver.get(loadProperties().getProperty("BASE_URL")+"hovers");
		MouseHoverPage mousehover=new MouseHoverPage(driver);
		Actions action=new Actions(driver);
		WebElement firstimg=mousehover.image1();
		WebElement secondimg=mousehover.image2();
		WebElement thirdimg=mousehover.image3();
		action.moveToElement(firstimg).perform();
		Assert.assertTrue("Image1 data is not displaying",firstimg.isDisplayed());
		Thread.sleep(2000);
		action.moveToElement(secondimg).perform();
		Assert.assertTrue("Image2 data is not displaying",secondimg.isDisplayed());
		Thread.sleep(2000);
		action.moveToElement(thirdimg).perform();
		Assert.assertTrue("Image3 data is not displaying",thirdimg.isDisplayed());
		
	}
	
	

}
