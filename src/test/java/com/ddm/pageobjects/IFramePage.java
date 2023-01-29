package com.ddm.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class IFramePage extends WebPage {

    @FindBy(css = "div.tox-notifications-container > div > button")
    protected WebElement closeButton;

    @FindBy(css = "div[role='application'] div[role='menubar'] > button")
    protected List<WebElement> menuOptions;

    @FindBy(css = "div[title='New document']")
    protected WebElement newDocumentOption;

    @FindBy(css = "div.tox-collection__group > div")
    List<WebElement> formatOptions;

    @FindBy(css = "#tinymce > p")
    WebElement messageArea;

    public IFramePage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void createNewDocument() {
        closeButton.click();
        menuOptions.get(0).click();
        newDocumentOption.click();
    }

    public void updateNewDocument(String text) {
        switchToParagraphIframe();
        waitUntilLoadedByCss("#tinymce > p");
        messageArea.sendKeys(text);
        mouseAndKeyBoardActions.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
        swithcToDefault();
        //Choose Format opiton and then Italic option
        menuOptions.get(3).click();
        formatOptions.get(1).click();
    }

    public String getMessageAreaText() {
        switchToParagraphIframe();
        String message = messageArea.getText();
        swithcToDefault();
        return message;
    }

    private void switchToParagraphIframe() {
        driver.switchTo().frame("mce_0_ifr");
    }

    private void swithcToDefault() {
        driver.switchTo().defaultContent();
    }

}
