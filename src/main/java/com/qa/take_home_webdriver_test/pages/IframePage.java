package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IframePage extends BasePage {

    // PAGE INITIALIZATION:
    public IframePage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By CROSS = By.cssSelector("div[aria-label='Close']");
    private static final By IFRAME = By.cssSelector("iframe[id='mce_0_ifr']");
    private static final By INPUT_BOX = By.cssSelector("#tinymce");

    // WEB ELEMENTS:
    private WebElement getCross() {
        wait.until(ExpectedConditions.elementToBeClickable(CROSS));
        return driver.findElement(CROSS);
    }

    private WebElement getInputBox() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(INPUT_BOX));
        return driver.findElement(INPUT_BOX);
    }

    public WebElement getIframe() {
        wait.until(ExpectedConditions.presenceOfElementLocated(IFRAME));
        return driver.findElement(IFRAME);
    }

    // METHODS:
    public void sendTxt(String existingTxt, String proposalTxt) {
        wait.until(ExpectedConditions.textToBe(INPUT_BOX, existingTxt));
        log.info("User clears input box. ");
        getInputBox().clear();
        log.info("User sends a text into input box. ");
        getInputBox().sendKeys(proposalTxt);
    }

    public void closeAlert() {
        log.info("User clicks on the cross for closing alert");
        getCross().click();
    }

    public void switchToFrame() {
        log.warn("User switch to the iFrame. ");
        driver.switchTo().frame(getIframe());
    }

    public String getInputBoxTxt() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(INPUT_BOX));
        String sentTxt = driver.findElement(INPUT_BOX).getText();
        log.info("User receives '" + sentTxt + "' from input box. ");
        return sentTxt;
    }

}


