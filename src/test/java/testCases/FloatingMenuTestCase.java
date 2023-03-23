package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.BaseClass;
import pages.floatingMenuPage;

public class FloatingMenuTestCase extends BaseClass {
	public floatingMenuPage floatingMenuPages;
	public FloatingMenuTestCase(){
		super();
	}

	@BeforeClass
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlFloatingMenu");
		floatingMenuPages = new floatingMenuPage();	
	}
	
	@Test(priority=1)
	public void validateFloatingMenuBeforeScroll() {
		Assert.assertTrue(floatingMenuPages.menuBeforeScroll());
	}
	
	@Test(priority=2)
	public void validateFloatingMenuAfterScroll() {
		Assert.assertTrue(floatingMenuPages.floatingMenuAfterScroll());
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
