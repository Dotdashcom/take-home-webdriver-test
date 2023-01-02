package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.MouseHover;

public class MouseHover_Test extends BaseClass {
	MouseHover mh;
	public MouseHover_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		mh=new MouseHover();
		
	}
	@Test
	public void tcHovers() throws InterruptedException {
		Assert.assertTrue(mh.getHoversBool());
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
