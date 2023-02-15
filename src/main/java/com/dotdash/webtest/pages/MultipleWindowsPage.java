package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindowsPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(33) > a")
    protected WebElement multipleWindowsButton;

    @FindBy(css = "#content > div > a")
    protected WebElement clickHere;

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToMultipleWindowsPage() {
        multipleWindowsButton.click();
        clickHere.click();
    }

    public boolean validateNewWindowHeader() {
        return switchToAnotherTab("New Window");
    }
}
