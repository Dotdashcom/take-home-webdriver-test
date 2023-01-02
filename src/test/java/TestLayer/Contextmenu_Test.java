package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.Context_menu;


public class Contextmenu_Test extends BaseClass {
	Context_menu con;
	public Contextmenu_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		con=new Context_menu();
		
	}
	@Test
	public void tcContextMenu_TC() throws InterruptedException {
		con.Con();
		Thread.sleep(2000);
		Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
