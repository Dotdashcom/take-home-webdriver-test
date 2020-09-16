package com.Test;

import java.awt.Checkbox;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.CheckBoxPage;

public class CheckBoxTest extends dotDashBase {
	WebDriver driver;


	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/context_menu");//to launch the browser
	}


	@Test 
	public void CheckAndUncheck(){
		CheckBoxPage cb = new CheckBoxPage(driver);
		cb.ClickCheckBox1();
		Assert.assertTrue(cb.checkBoxStatus());
		//Assert.assertTrue(checkBox.checkBoxesStatus());
		cb.ClickCheckBox2();
		Assert.assertFalse(cb.checkBoxStatus());

	}

	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();

	}

}

