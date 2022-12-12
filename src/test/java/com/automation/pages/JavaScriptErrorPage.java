package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JavaScriptErrorPage extends BasePage {

    @FindBy(xpath = "//a[@href='/javascript_error']")
    WebElement link;

    @FindBy(xpath = "//body[@onload='loadError()']")
    WebElement text;

    public void clickOnLink() {
        link.click();
    }

    public void verifyError() {
        Assert.assertTrue(text.isDisplayed());
    }
}
