package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.LoginFailPage;
import com.POM.LoginSuccessPage;

public class LoginFailTest extends dotDashBase {
	WebDriver driver;


	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/login");//to launch the browser
	}


	@Test 
	public void LoginCheck(){
		LoginFailPage login = new LoginFailPage(driver);
		login.loginTest("tomsmith", "WrongPassword!");//this should fail the log in

	}



	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
