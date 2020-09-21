package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class IFrameTest extends Base {

	private String text1 = "Frame Testing";

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/iframe ");
	}

	// Test switches to Iframe and types some text.
	// Test asserts that the typed text is as expected.

	@Test

	public void HandleFrame() {

		WebElement bodyFrame = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		WebElement contentBox = driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));

		driver.switchTo().frame(bodyFrame);
		DriverUtility.clearTextUsingSendKeys(contentBox);
		DriverUtility.enterText(contentBox, text1);
		Assert.assertEquals(driver.findElement(By.className("mce-content-body ")).getText(), text1);

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();
	}
}