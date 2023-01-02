package TestLayer;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.DynamicLoading;

public class DynamicLoading_Test extends BaseClass{
	DynamicLoading dl;
	public DynamicLoading_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		dl=new DynamicLoading();
		
	}
	@Test
	public void DynamicLoading_TC() throws InterruptedException {
		Thread.sleep(2000);
		dl.startBtn.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(dl.msg));
		Assert.assertEquals(dl.msg.getText(), "Hello World!");
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
