package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.JavaScriptAlertsPage;

public class JavaScriptAlertsTest extends TestBase{

    JavaScriptAlertsPage javaScriptAlertsPage;

    public JavaScriptAlertsTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/javascript_alerts");
        javaScriptAlertsPage = new JavaScriptAlertsPage();
    }

    @Test()
    public void verifyJavaScriptAlerts() {

        javaScriptAlertsPage.jsAlertButtonClick();
        Assert.assertEquals(driver.switchTo().alert().getText(),"I am a JS Alert");
        driver.switchTo().alert().accept();

        javaScriptAlertsPage.jsConfirmButtonClick();
        Assert.assertEquals(driver.switchTo().alert().getText(),"I am a JS Confirm");
        driver.switchTo().alert().accept();

        javaScriptAlertsPage.jsPromptButtonClick();
        String value = "Test";
        driver.switchTo().alert().sendKeys(value);
        driver.switchTo().alert().accept();
        Assert.assertEquals(javaScriptAlertsPage.getJsPromptText(),"You entered: "+value);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
