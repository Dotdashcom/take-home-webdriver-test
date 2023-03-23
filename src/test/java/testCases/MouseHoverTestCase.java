package testCases;

import org.testng.Assert;

import org.testng.annotations.*;

import pages.BaseClass;
import pages.MouseHoverPage;

public class MouseHoverTestCase extends BaseClass {
	public MouseHoverPage mouseHoverPage;
	public MouseHoverTestCase(){
		super();
	}

	@BeforeClass
	public void setUp(){
		System.out.println("Before Class");
		initialization("urlMouseHover");
		mouseHoverPage = new MouseHoverPage();	
	}
	
	@Test(priority=1)
	public void validateImage1() {
		Assert.assertTrue(mouseHoverPage.image1());
	}
	@Test(priority=2)
	public void validateImage2() {
		Assert.assertTrue(mouseHoverPage.image2());
	}
	@Test(priority=3)
	public void validateImage3() {
		Assert.assertTrue(mouseHoverPage.image3());
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
