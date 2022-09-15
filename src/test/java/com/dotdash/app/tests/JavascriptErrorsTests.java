package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.app.pageobjects.JavascriptErrorsPage;
import com.dotdash.app.pageobjects.LoginPage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JavascriptErrorsTests extends BaseTest {
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
