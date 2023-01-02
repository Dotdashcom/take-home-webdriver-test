package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.DynamicContent;

public class DynamicContent_Test extends BaseClass {
	DynamicContent dc;
	public DynamicContent_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		dc=new DynamicContent();
		
	}
	@Test
	public void dynamiccontent_TC() throws InterruptedException{
		String beforeText = dc.text1.getText();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		String afterText = dc.text1.getText();
		Assert.assertNotEquals(beforeText, afterText);

		beforeText = dc.text2.getText();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		afterText = dc.text2.getText();
		Assert.assertNotEquals(beforeText, afterText);

	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
