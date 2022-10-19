package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Floatingmenu;

public class Floatingmenutest extends BaseTest {

	public Floatingmenutest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("floatingmenuurl"));
		Thread.sleep(1000);
		fmenu = new Floatingmenu(); 
	}
	
	Floatingmenu fmenu;
	
	@Test
	public void floatinmenutest() {
		fmenu.floatingmenu();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
	}
}