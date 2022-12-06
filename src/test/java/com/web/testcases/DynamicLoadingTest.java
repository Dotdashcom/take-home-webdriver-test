package com.web.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.DynamicLoadingPage;

import java.time.Duration;

public class DynamicLoadingTest extends TestBase{

    DynamicLoadingPage dynamicLoadingPage;

    public DynamicLoadingTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/dynamic_loading/2");
        dynamicLoadingPage = new DynamicLoadingPage();
    }


    @Test()
    public void verifyDynamicPageLoad(){
        dynamicLoadingPage.btnClick();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.element()));
        Assert.assertEquals(dynamicLoadingPage.element().getText(),"Hello World!");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
