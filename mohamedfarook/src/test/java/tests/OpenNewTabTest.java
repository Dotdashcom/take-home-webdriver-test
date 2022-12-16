package tests;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.OpenNewTabPage;

public class OpenNewTabTest extends BaseClass {
	OpenNewTabPage openNewTabObj;

	public OpenNewTabTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/windows");
		openNewTabObj = new OpenNewTabPage();
	}

	@Test
	public void openNewTabTest() throws InterruptedException {
		openNewTabObj.clickHereButton.click();
		Thread.sleep(3000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String each : allWindowHandles) {
			driver.switchTo().window(each);
			System.out.println("Current title while switching windows: " + driver.getTitle());
		}
		Assert.assertEquals(driver.getTitle(), "New Window");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
