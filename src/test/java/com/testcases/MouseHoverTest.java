package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.MouseHoverPage;

public class MouseHoverTest extends Base{
	
	MouseHoverPage mhp;
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("Hovers")).click();
		mhp=new MouseHoverPage();
	}
	
	@Test
	public void validateAdditionalInformationIsDisplayedForEachImage() {
		mhp.hoverImage_1();
		Assert.assertEquals(mhp.getImage_1Name(),"name: user1");
		Assert.assertTrue(mhp.viewProfileLink_1IsDisplayed());
		
		mhp.hoverImage_2();
		Assert.assertEquals(mhp.getImage_2Name(),"name: user2");
		Assert.assertTrue(mhp.viewProfileLink_2IsDisplayed());
		
		mhp.hoverImage_3();
		Assert.assertEquals(mhp.getImage_3Name(),"name: user3");
		Assert.assertTrue(mhp.viewProfileLink_3IsDisplayed());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
