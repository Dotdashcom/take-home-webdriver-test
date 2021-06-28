package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {

    WebDriver localDriver;
    public ContextMenuPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/context_menu']")
    @CacheLookup
    WebElement linkContextMenu;

    @FindBy(id = "hot-spot")
    @CacheLookup
    WebElement box;

    public void clickContextMenuLink() {
        linkContextMenu.click();
    }

    public void clickOnBox() {
        Actions actions = new Actions(localDriver);
        actions.contextClick(box).perform();
    }
}
