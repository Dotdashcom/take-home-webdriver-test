package com.dotdash.selenium;

import com.dotdash.selenium.pages.HomePage;
import com.dotdash.selenium.pages.JavascriptErrorsPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JavascriptErrorsTests extends SetUpTearDown {
    HomePage homePage;
    JavascriptErrorsPage javascriptErrorsPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        javascriptErrorsPage = new JavascriptErrorsPage(driver);
    }

    @Test
    public void verifyJSConsoleError(){
        String expectedError = "Cannot read properties of undefined (reading 'xyz')";
        homePage.clickJsErrorsLink();
        Assert.assertTrue(javascriptErrorsPage.getJSConsoleError().contains(expectedError));
    }
}
