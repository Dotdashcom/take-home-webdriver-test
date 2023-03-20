package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginTest extends Util{
	
	protected LoginPage loginPage;
	
	@BeforeMethod
    public void setUp(){
        driver = getDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
	@Test
    public void success_Login_Test(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("loginurl"));
        Assert.assertTrue(driver.findElement(By.cssSelector("div#flash")).getAttribute("innerText").contains("You logged into a secure area!"));
    }
    @Test
    public void invalid_Username_Test(){
        loginPage.doLogin(prop.getProperty("invalidusername"), prop.getProperty("password"));
        Assert.assertTrue(driver.findElement(By.cssSelector("div#flash")).getAttribute("innerText").contains("Your username is invalid!"));
    }
    @Test
    public void invalid_Password_Test(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("invalidpassword"));
        Assert.assertTrue(driver.findElement(By.cssSelector("div#flash")).getAttribute("innerText").contains("Your password is invalid!"));
    }


    @AfterMethod
    public void endTest(){
        teardown();
    }
}
