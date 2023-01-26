package com.qa.selenium.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.MouseHoverPage;
import com.qa.selenium.util.TestUtil;

public class MouseHoverPageTest extends TestBase{

	
	MouseHoverPage mouseHoverPage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "hovers");
		mouseHoverPage = new MouseHoverPage();
	}
	
	@Test(priority=1)
	public void firstImgTest() throws InterruptedException{
		mouseHoverPage.Img1display();

		Assert.assertEquals(mouseHoverPage.FirstText(), prop.getProperty("Hover1"));
	}
	
	@Test(priority=2)
	public void secondImgTest() throws InterruptedException {
		mouseHoverPage.Img2display();
		Assert.assertEquals(mouseHoverPage.secondText(), prop.getProperty("Hover2"));
	}
	
	@Test(priority=3)
	public void thirdtImgTest() throws InterruptedException {
		mouseHoverPage.Img3display();
		Assert.assertEquals(mouseHoverPage.ThirdText(), prop.getProperty("Hover3"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
