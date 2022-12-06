package com.web.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.FloatingMenuPage;


public class FloatingMenuTest extends TestBase{

    FloatingMenuPage floatingMenuPage;

    public FloatingMenuTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/floating_menu");
        floatingMenuPage = new FloatingMenuPage();
    }


    @Test()
    public void verifyFloatingMenuIsPresent(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        if(floatingMenuPage.fMenu().isDisplayed()) {
            Assert.assertTrue(true);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
