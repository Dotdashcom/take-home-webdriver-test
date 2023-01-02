package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.DropDown;

public class DropDown_Test extends BaseClass {
	DropDown dp;
	public DropDown_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		dp=new DropDown ();
		
	}
	@Test
	public void tcDropDown_TC() throws InterruptedException {
		Assert.assertEquals(dp.dropDown("Option 1"), "Option 1");
		Thread.sleep(2000);

		Assert.assertEquals(dp.dropDown("Option 2"), "Option 2");
		Thread.sleep(2000);
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
