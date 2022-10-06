package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FloatingMenuPage extends BasePage {

    @FindBy(css = "#menu")
    private WebElement menu;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuDisplayed() {
        return menu.isDisplayed();
    }
}
