package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.CheckBoxPage;
import com.POM.ContextClickPage;
import com.POM.LoginSuccessPage;

public class LoginSucessTest extends dotDashBase {
	WebDriver driver;


	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/login");//to launch the browser
	}


	@Test 
	public void LoginCheck(){
		LoginSuccessPage login = new LoginSuccessPage(driver);
		login.loginTest("tomsmith", "SuperSecretPassword!");

	}

	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();

	}

}

