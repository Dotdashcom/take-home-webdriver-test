package org.example;

import Resources.driverConfig;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.loginPage;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppTest extends driverConfig
{
    public WebDriver driver;
    public String uname;
    public String psw;


    @BeforeTest
    void startwebdriver() throws IOException
    {
        driver= invokedriver();
        uname=pr.getProperty("name");
        psw=pr.getProperty("cred");
    }


    @Test
    void executeloginasuccess() throws InterruptedException {
        driver.get(baseUrl+"login");
        loginPage lp=new loginPage(driver);
        lp.enteruser().sendKeys(uname);
        lp.entercreds().sendKeys(psw);
        lp.submit().click();
        Assert.assertTrue(lp.loginmessage().isDisplayed(),"Failed to Login!");

        WebDriverWait w=new WebDriverWait(driver,6);
        w.until(ExpectedConditions.visibilityOf(lp.loginmessage()));

//        Thread.sleep(6000);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        lp.logout().click();

    }


    @Test
    void executeloginfailure() throws InterruptedException {
        driver.get(baseUrl+"login");
        loginPage lp=new loginPage(dr);
        lp.enteruser().sendKeys(uname);
        lp.entercreds().sendKeys(psw+"1");
        lp.submit().click();
//        Thread.sleep(6000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        Assert.assertTrue(lp.loginfailed().isDisplayed(),"Failed to Login Sucessfully!");
    }

    @AfterTest
    void closebrowser()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
