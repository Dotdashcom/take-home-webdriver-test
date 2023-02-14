package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(19) > a")
    protected WebElement floatingMenuButton;

    @FindBy(css = "#page-footer > div > div > a")
    protected WebElement scrollButton;

    @FindBy(css = "#menu > ul > li:nth-child(1) > a")
    protected WebElement homeButton;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToFloatingMenuPage() {
        floatingMenuButton.click();
    }

    public void scrollToPageFooter() {
        scrollToElementWithJs(driver, scrollButton);
    }

    public boolean isHomeOptionDisplayed() {
        return homeButton.isDisplayed();
    }
}
