package com.academy.techcenture.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class OpenInNewTabPage extends BasePage{
    public OpenInNewTabPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//a[normalize-space()='Click Here']")
    private WebElement clickHereLink;

    @FindBy(xpath = "//h3[normalize-space()='New Window']")
    private WebElement newWindowMsg;


    public void openInNewTab(){
        String mainWindow = driver.getWindowHandle();
        String url = clickHereLink.getAttribute("href");
        driver.switchTo().newWindow(WindowType.TAB).get(url);
        String childWindow = driver.getWindowHandle();
        softAssert.assertTrue(newWindowMsg.isDisplayed(), "New window message is not displayed");
    }
}
