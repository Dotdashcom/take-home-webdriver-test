package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/context_menu")
public class ContextMenu extends WebPage {

    @FindBy(id = "hot-spot")
    private WebElement contextMenuSpotBox;

    public Alert openContextMenu() {
        contextClick(contextMenuSpotBox);
        return switchToAlert();
    }
}
