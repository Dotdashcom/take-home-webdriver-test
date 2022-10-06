package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class IFramesPage extends BasePage {

    @FindBy(css = "div.tox-icon svg")
    private WebElement toxNotificationClose;

    @FindBy(css = "#tinymce > p")
    private WebElement iframeInnerText;

    public IFramesPage(WebDriver driver) {
        super(driver);
    }

    public void closeToxNotification() {
        WebDriverWait wdWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.tox-icon svg")));
        toxNotificationClose.click();
    }

    public String getIFrameInnerText() {
        return iframeInnerText.getText();
    }

    public void setIframeInnerText(String text) {
        iframeInnerText.clear();
        iframeInnerText.sendKeys(text);
    }
}
