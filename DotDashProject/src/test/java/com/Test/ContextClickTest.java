package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.CheckBoxPage;
import com.POM.ContextClickPage;

public class ContextClickTest extends dotDashBase {

	WebDriver driver;


	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/checkboxes");//to launch the browser
	}


	@Test 
	public void Contextclick(){
		ContextClickPage cp = new ContextClickPage(driver);
		cp.contextClick();

		//this will compare the actual and expected result
		Assert.assertEquals(cp.alert(),"You selected a context menu" );
	}



	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();


	}


}
