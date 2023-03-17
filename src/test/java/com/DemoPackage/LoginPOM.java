package com.DemoPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Demo.Pages.HomePage;
import com.Demo.Pages.SignInPage;

/***
 * Tests login feature
 */
public class LoginPOM {
	String driverPath = "D:\\Humber\\selenium\\my\\chromedriver.exe";
	public ChromeDriver driver ;
	@BeforeTest
	public void launchBrowser() {
	System.setProperty("webdriver.chrome.driver", driverPath);
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(option);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
  @Test
  public void testLoginWithCorrectCredentials() {  
	SignInPage signInPage = new SignInPage(driver);
    HomePage homePage = signInPage.loginValidUser("tomsmith", "SuperSecretPassword!");
    Assert.assertEquals(homePage.getExpectedURL(), homePage.getActualURL());
  }
  @Test
  public void testLoginWithIncorrectCredentials() {
  SignInPage signInPage = new SignInPage(driver);
  HomePage homePage = signInPage.loginValidUser("tomsmith", "password");
  Assert.assertNotEquals(homePage.getExpectedURL(), homePage.getActualURL());
}
  @AfterTest
  public void terminateBrowser(){
	  driver.close();
  }

}
