package com.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.DropdownPage;

public class DropdownTest extends Base{
	
	DropdownPage dp;
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("Dropdown")).click();
		dp= new DropdownPage();
	}
	

	@Test
	public void verifyOption1AndOption2AreSelected() {
		dp.clickOnDropdownMenu();
		dp.selectOption1FromDropdown();
		Assert.assertEquals(dp.getTheSelectedOption(),"Option 1");
		
		dp.clickOnDropdownMenu();
		dp.selectOption2FromDropdown();
		Assert.assertEquals(dp.getTheSelectedOption(),"Option 2");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
