package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

public class NewTab extends WebPage {

    @FindBy(tagName = "h3")
    private WebElement newTabText;

    public String getNewTabText() {
        return getText(newTabText);
    }
}
