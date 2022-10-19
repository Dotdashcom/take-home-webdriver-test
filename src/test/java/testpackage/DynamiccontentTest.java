package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Dynamiccontent;

public class DynamiccontentTest extends BaseTest {

	public DynamiccontentTest() {
		super();
	}
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("dynamiccontenturl"));
		Thread.sleep(1000);
		dynamiccontent = new Dynamiccontent();
	}
	
	Dynamiccontent dynamiccontent;
	
	@Test
	public void Dynamiccontent1test() {
		dynamiccontent.DynamicContent1();
		dynamiccontent.DynamiccontentAssertion();
	}
	@Test
	public void Dynamiccontent2test() {
		dynamiccontent.DynamicContent2();
		dynamiccontent.DynamiccontentAssertion();
	}
	@Test
	public void Dynamiccontent3test() {
		dynamiccontent.DynamicContent3();
		dynamiccontent.DynamiccontentAssertion();
	}
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
	 


}
