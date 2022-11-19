package com.dotdash.pages;

import annotations.NotVisible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

public class LoginSuccess extends WebPage {

    @NotVisible
    @FindBy(id = "flash")
    private WebElement successMessageLabel;

    @FindBy(tagName = "h2")
    private WebElement secureAreaHeaderLabel;

    @FindBy(className = "subheader")
    private WebElement subHeaderLabel;

    @FindBy(css = ".icon-signout")
    private WebElement logoutButton;

    public boolean isSuccessMessageVisible() {
        return isVisible(successMessageLabel);
    }

    public Login logout() {
        click(logoutButton);
        return new Login();
    }
}
