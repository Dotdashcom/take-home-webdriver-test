package page.object.model.page.object.model.demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseInit.BaseInit;

public class SDemo201Test {
	WebDriver driver;
	
	public SDemo201Test() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void getTitleTest() throws InterruptedException {
	 
		pages.MainPage mainpageob = new pages.MainPage(driver);
		  BaseInit.openBrowser("http://localhost:7080"); Thread.sleep(3000); String
		  welcometxt = mainpageob.welcomeMainPage();
		  System.out.println(welcometxt); 
		  assertEquals(welcometxt,"Welcome to the-internet");
		  BaseInit.tearDown();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		pages.LoginPage loginpageob = new pages.LoginPage(driver);
		pages.HomePage homepageob = new pages.HomePage(driver);
		BaseInit.openBrowser("http://localhost:7080/login");
		Thread.sleep(3000);
		loginpageob.enterUsername("tomsmith");
		loginpageob.enterPassword("SuperSecretPassword!");
		loginpageob.login();
		String loginsuccesstxt = homepageob.loginSuccess();
		assertEquals(loginsuccesstxt, "You logged into a secure area!");
		Thread.sleep(3000);
		BaseInit.tearDown();
	}
}
