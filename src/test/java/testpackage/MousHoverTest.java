package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.MouseHover;

public class MousHoverTest extends BaseTest {

	public MousHoverTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("MouseHoverurl"));
		Thread.sleep(1000);
		mh = new MouseHover();
	}
	
	MouseHover mh;
	@Test
	public void img1test() {
		mh.img1();
	}
	
	public void img2test() {
		mh.img2();
	}
	
	public void img3test() {
		mh.img3();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
}