package com.test.localhost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JsErrorPage {

    public JsErrorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

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

