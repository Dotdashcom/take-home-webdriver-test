package TestLayer;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.DynamicControls;

public class DynamicControls_Test extends BaseClass{
	
	DynamicControls dcs;
	public DynamicControls_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		dcs=new DynamicControls();
		
	}
	@Test
	public void DynamicControls_TC() throws InterruptedException {
		dcs.removeBtn.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(dcs.addBtn));
		Assert.assertTrue(dcs.addBtn.isDisplayed());

		dcs.addBtn.click();
		 wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(dcs.removeBtn));
		Assert.assertTrue(dcs.checkBox.isDisplayed());

		dcs.enableBtn.click();
		 wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(dcs.disableBtn));
		Assert.assertTrue(dcs.textBox.isEnabled());

		dcs.disableBtn.click();
		 wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(dcs.enableBtn));
		Assert.assertFalse(dcs.textBox.isEnabled());
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
