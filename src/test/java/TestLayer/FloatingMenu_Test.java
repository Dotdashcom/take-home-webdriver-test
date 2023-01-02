package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.FloatingMenu;

public class FloatingMenu_Test extends BaseClass{
	FloatingMenu fm;
		public  FloatingMenu_Test() {
			super();
		}
		@BeforeMethod
		public void initsetup() {
			initiation();
			fm=new  FloatingMenu();
			
		}

		@Test
		public void FloatingMenu_TC() throws InterruptedException {
			Assert.assertTrue(fm.getFloatingMenu());
		}
		@AfterMethod
		public void close() {
			driver.close();
		}


}
