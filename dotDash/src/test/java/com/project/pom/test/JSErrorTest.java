package com.project.pom.test;

import com.project.pom.page.JSError;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JSErrorTest {

    private WebDriver driver;
    JSError jsError;

    @Before
    public void setUp(){
        jsError = new JSError(driver);
        driver = jsError.chromeDriverConnection();
        jsError.visit("/javascript_error");
    }

    @Test
    public void jsErrorTest(){
        assertTrue(jsError.compareErrorMessage());
    }

    @After
    public void end(){ driver.quit(); }
}
