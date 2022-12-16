package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.MouseHoverPage;

public class MouseHoverTest extends BaseClass {
	MouseHoverPage mouseHoverObj;

	public MouseHoverTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/hovers");
		mouseHoverObj = new MouseHoverPage();
	}

	@Test
	public void mouseHoverTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(mouseHoverObj.picture1).perform();
		Assert.assertTrue(mouseHoverObj.picture1.isDisplayed(), "name: user1");
		Thread.sleep(2000);
		actions.moveToElement(mouseHoverObj.picture3).perform();
		Assert.assertTrue(mouseHoverObj.picture3.isDisplayed(), "name: user3");
		Thread.sleep(2000);
		actions.moveToElement(mouseHoverObj.picture2).perform();
		Assert.assertTrue(mouseHoverObj.picture2.isDisplayed(), "name: user2");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
