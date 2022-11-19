package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/windows")
public class OpenNewTab extends WebPage {

    @FindBy(css = ".example > a")
    private WebElement clickHereLink;

    public NewTab openNewTab() {
        click(clickHereLink);
        switchToTab(2);
        return new NewTab();
    }
}
