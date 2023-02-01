package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;


public class IframePage extends BasePage {
    public IframePage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//p")
    private WebElement textInput;

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    public void verifyIframe() {
        softAssert.assertTrue(iframe.isDisplayed(),"Frame is not displayed");
        driver.switchTo().frame("mce_0_ifr");
        textInput.clear();
        textInput.sendKeys("Hello world!");
        softAssert.assertEquals(textInput.getText().trim(),"Hello world!", "Text is not match");
    }

}
