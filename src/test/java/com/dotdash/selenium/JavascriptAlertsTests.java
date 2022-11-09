package com.dotdash.selenium;

import com.dotdash.selenium.pages.HomePage;
import com.dotdash.selenium.pages.JavascriptAlertsPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JavascriptAlertsTests extends SetUpTearDown {
    HomePage homePage;
    JavascriptAlertsPage javascriptAlertsPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        javascriptAlertsPage = new JavascriptAlertsPage(driver);
    }

    @Test
    public void verifyAlertButtonMessage(){
        homePage.clickJsAlertsLink();
        javascriptAlertsPage.clickAlertButton();
        javascriptAlertsPage.acceptAlert();
        Assert.assertEquals("You successfuly clicked an alert", javascriptAlertsPage.getResultMessage());
    }

    @Test
    public void verifyConfirmButtonMessage(){
        homePage.clickJsAlertsLink();
        javascriptAlertsPage.clickConfirmButton();
        javascriptAlertsPage.acceptAlert();
        Assert.assertEquals("You clicked: Ok", javascriptAlertsPage.getResultMessage());
    }

    @Test
    public void verifyPromptButtonMessage(){
        String promptText = "Hello World!";
        homePage.clickJsAlertsLink();
        javascriptAlertsPage.clickPromptButton();
        javascriptAlertsPage.typePrompt(promptText);
        Assert.assertEquals("You entered: " + promptText, javascriptAlertsPage.getResultMessage());
    }
}
