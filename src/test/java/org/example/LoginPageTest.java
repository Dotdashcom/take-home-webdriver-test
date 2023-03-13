package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePage {

    protected LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    @Test
    public void validCredslogintest(){
        loginPage.doLogin("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:7080/secure");
        Assert.assertTrue(driver.findElement(By.cssSelector("div#flash")).getAttribute("innerText").contains("You logged into a secure area!"));
    }
    @Test
    public void invalidUsernamelogintest(){
        loginPage.doLogin("tom", "SuperSecretPassword!");
        Assert.assertTrue(driver.findElement(By.cssSelector("div#flash")).getAttribute("innerText").contains("Your username is invalid!"));
    }
    @Test
    public void invalidPasswordlogintest(){
        loginPage.doLogin("tomsmith", "SuperPassword!");
        Assert.assertTrue(driver.findElement(By.cssSelector("div#flash")).getAttribute("innerText").contains("Your password is invalid!"));
    }


    @AfterMethod
    public void endTest(){
        teardown();
    }

}
