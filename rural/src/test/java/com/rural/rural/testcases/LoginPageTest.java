package com.rural.rural.testcases;

import com.rural.rural.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/login");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "userdata", dataProviderClass = dataProvider.DataProviderFromJson.class)
    public void login(dataDefinition.MyUserData userData) {
        loginPage.inputUsername.sendKeys(userData.username);
        loginPage.inputPassword.sendKeys(userData.password);
        loginPage.buttonLogin.click();
        String loginMsj=loginPage.h4WelcomeTheSecureArea.getText();


        // verify if the login is successful
        Assert.assertTrue(loginMsj.equals("Welcome to the Secure Area. When you are done click logout below."), "Login was successful!");


        // close the browser
        driver.quit();

    }

    @Test(dataProvider = "userdataFailed", dataProviderClass = dataProvider.DataProviderFromJson.class)
    public void loginFailed(dataDefinition.MyUserData userData) {
        loginPage.inputUsername.sendKeys(userData.username);
        loginPage.inputPassword.sendKeys(userData.password);
        loginPage.buttonLogin.click();
        String loginMsj=loginPage.loginFailedMsg.getText();


        // Assert if the login is unsuccessful
        Assert.assertFalse(loginMsj.equals("Your username is invalid!"), "Login was unsuccessful.");



        // close the browser
        driver.quit();

    }

}
