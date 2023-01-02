package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.WindowsPage;

public class WindowsPage_Test extends BaseClass{
	WindowsPage wp;
	public WindowsPage_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		wp=new WindowsPage();
		
	}
	@Test
	public void tcWindowLink() throws InterruptedException {
		Assert.assertTrue(wp.getNewTab());
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
