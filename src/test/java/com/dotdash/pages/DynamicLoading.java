package com.dotdash.pages;

import annotations.NotVisible;
import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/dynamic_loading/2")
public class DynamicLoading extends WebPage {

    @FindBy(css = "#start > button")
    private WebElement startButton;

    @NotVisible
    @FindBy(id = "finish")
    private WebElement helloWorldText;

    public DynamicLoading start() {
        click(startButton);
        return this;
    }

    public boolean isHelloWorldMessageDisplayed() {
        return isVisible(helloWorldText, 10);
    }
}
