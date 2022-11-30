package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class IframePage extends BasePage {

    @FindBy(how = How.CSS, using = "#mce_0_ifr")
    private WebElement iframeField;

    @FindBy(how = How.CSS, using = "#tinymce")
    private WebElement iframeContentField;

    public IframePage(WebDriver driver) {
        super(driver);
    }

    public IframePage goToIframePage() {
        driver.get(BASEURL + "/iframe");
        return this;
    }

    public IframePage writeToIframe() {
        waitForAvailabilityOfFrame(iframeField);
        waitForVisibilityOf(iframeContentField).clear();
        waitForVisibilityOf(iframeContentField).sendKeys("IFRAME TEST");
        return this;
    }

    public String getIframeText() {
        return waitForVisibilityOf(iframeContentField).getText();
    }
}
