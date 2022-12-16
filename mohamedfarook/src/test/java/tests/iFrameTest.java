package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.IframePage;

public class iFrameTest extends BaseClass {
	IframePage iFrameObj;

	public iFrameTest() {
		super();
	}
	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/iframe");
		iFrameObj = new IframePage();
	}

	@Test
	public void iFrameTesting() throws InterruptedException {
		driver.switchTo().frame(0);
		Thread.sleep(3000);
        System.out.println(iFrameObj.text.getText());
        Assert.assertEquals(iFrameObj.text.getText(), "Your content goes here.");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}