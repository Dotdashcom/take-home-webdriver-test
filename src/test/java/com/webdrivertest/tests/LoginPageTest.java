package com.webdrivertest.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webdrivertest.base.BasePage;
import com.webdrivertest.pages.LoginPage;
import com.webdrivertest.utils.AppConstants;
import com.webdrivertest.utils.Credentials;
import com.webdrivertest.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic_101: create login feature tests")
@Feature("UserStory_01: create login tests using invalid and valid credentials")
public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	Credentials userCred;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	@BeforeMethod()
	public void setUp() {
		log.info("starting ---------->>>> LoginPageTest");
		basePage = new BasePage();
		prop = basePage.init_properites();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("loginPage"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 1, description = "get page title method", enabled = true)
	@Description("verify login page title")
	@Severity(SeverityLevel.NORMAL)
	public void testPageTitleTest() throws InterruptedException {
		log.info("starting -------->>> testPageTitleTest");
		String title = loginPage.getPageTitle();
		System.out.println("login page title "+ title);
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
		log.info("ending -------->>> testPageTitleTest");
	}
	/**
	 * Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
	 */
	@Test(priority = 2, description = "valid username and password login", enabled = true)
	@Description("login system valid credentials")
	@Severity(SeverityLevel.CRITICAL)
	public void testLoginValidCreds() {
		log.info("starting -------->>> testLoginValidCreds");
		loginPage.doLogin(userCred);
		String successMessage = loginPage.getText();
		Assert.assertEquals(successMessage, AppConstants.SUCCESS_MESSAGE);
		log.info("ending -------->>> testLoginValidCreds");
	}
	@DataProvider
	public Object[][] getLoginInvalidData() {
		Object data[][] = ExcelUtils.getTestData("testdata");
		return data;
	}
    /**
     * Login Success: http://localhost:7080/login -- use excelsheet for invalid credentials
     * @param username
     * @param pwd
     */
	@Test(priority=3, dataProvider= "getLoginInvalidData", description = "invalid username and password login", enabled=true)
	@Description("verify login system invalid credentials")
	@Severity(SeverityLevel.CRITICAL)
	public void testLoginInvalidCreds(String username, String pwd) {
		log.info("starting -------->>> testLoginInvalidCred");
		userCred.setAppUsername(username);
		userCred.setAppPassword(pwd);
		loginPage.doLogin(userCred);
		String errorMessage = loginPage.getText();
		Assert.assertEquals(errorMessage, AppConstants.ERROR_MESSAGE);
		log.info("starting -------->>> testLoginInvalidCred");
	}
	@AfterMethod ()
	public void tearDown() {
		driver.quit();
	}

}
