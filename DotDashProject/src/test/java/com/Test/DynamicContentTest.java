package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.DynamicContent;

public class DynamicContentTest extends dotDashBase {
	WebDriver driver;


	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/dynamic_content");//to launch the browser
	}

	@Test
	public void dropDownTest(){
		DynamicContent contentPage = new DynamicContent(driver);
		//Assert.assertTrue(contentPage.dynamicContent());

	}

}
