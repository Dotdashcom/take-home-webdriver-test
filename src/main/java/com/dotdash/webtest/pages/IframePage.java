package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(22) > a")
    protected WebElement frameButton;

    @FindBy(css = "#content > div > ul > li:nth-child(2) > a")
    protected WebElement iFrameButton;

    @FindBy (css = ".tox-notifications-container > div > button")
    protected WebElement xButton;

    @FindBy(tagName = "p")
    protected WebElement messageInBox;

    public IframePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToIFramePage() {
        frameButton.click();
        iFrameButton.click();
        xButton.click();
    }

    public void notificationMsg() {
        driver.switchTo().defaultContent();
    }

    public String sendAndGetText() {
        driver.switchTo().frame("mce_0_ifr");
        messageInBox.clear();
        messageInBox.sendKeys("TinyMCE WYSIWYG Editor");
        return messageInBox.getText();
    }
}
