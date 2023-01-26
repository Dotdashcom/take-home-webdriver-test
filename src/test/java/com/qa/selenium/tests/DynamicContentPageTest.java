package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.DynamicContentPage;

public class DynamicContentPageTest extends TestBase{

	DynamicContentPage dynamicContentpage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "dynamic_content");
		dynamicContentpage = new DynamicContentPage();
	}
	
	@Test(priority =1)
	public void firstBoxTest() {
	String beforeRefresh =	dynamicContentpage.checkFirstbox();
	driver.navigate().refresh();
	driver.navigate().refresh();
	String afterRefresh =	dynamicContentpage.checkFirstbox();

	if (beforeRefresh.equals(afterRefresh)) {
		driver.navigate().refresh();
		driver.navigate().refresh();
			}
	else {
	System.out.println(beforeRefresh);
	System.out.println(afterRefresh);
	
	Assert.assertNotEquals(beforeRefresh, afterRefresh, "Content did not changed after Refresh"); 
			}
	}
	
	@Test(priority =2)
	public void secondBoxTest() {
	String beforeRefresh =	dynamicContentpage.checkSecondbox();
	driver.navigate().refresh();
	driver.navigate().refresh();
	String afterRefresh =	dynamicContentpage.checkSecondbox();

	if (beforeRefresh.equals(afterRefresh)) {
		driver.navigate().refresh();
		driver.navigate().refresh();
			}
	else {
	System.out.println(beforeRefresh);
	System.out.println(afterRefresh);
	
	Assert.assertNotEquals(beforeRefresh, afterRefresh, "Content did not changed after Refresh");
	}
	}
	
	@Test(priority =3)
	public void thirdBoxTest() {
	String beforeRefresh =	dynamicContentpage.checkThirdbox();
	driver.navigate().refresh();
	driver.navigate().refresh();
	String afterRefresh =	dynamicContentpage.checkThirdbox();

	if (beforeRefresh.equals(afterRefresh)) {
		driver.navigate().refresh();
		driver.navigate().refresh();
			}
	else {
	System.out.println(beforeRefresh);
	System.out.println(afterRefresh);
	
	Assert.assertNotEquals(beforeRefresh, afterRefresh, "Content did not changed after Refresh");
	}
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	

}
