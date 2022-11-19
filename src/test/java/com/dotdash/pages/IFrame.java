package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/iframe")
public class IFrame extends WebPage {

    @FindBy(id = "mce_0_ifr")
    private WebElement iFrameContainer;

    @FindBy(id = "tinymce")
    private WebElement iFrameInput;

    public String getInputText() {
        return getText(iFrameInput);
    }

    public void enterText(String text) {
        switchToIFrame(iFrameContainer);
        type(iFrameInput, text);
    }
}
