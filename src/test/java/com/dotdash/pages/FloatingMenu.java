package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/floating_menu")
public class FloatingMenu extends WebPage {

    @FindBy(id = "menu")
    private WebElement floatingMenuContainer;

    public boolean isFloatingMenuDisplayed() {
        return isVisible(floatingMenuContainer);
    }

    public FloatingMenu scrollToPageBottom() {
        scrollToBottom();
        return this;
    }
}
