package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class FramePage extends BasePage {

    private final By textField = By.tagName("p");

    private final By iframeLink = By.xpath("//a[text()='iFrame']");

    public FramePage clickOnIFrameLink() {
        click(iframeLink, CLICKABLE, "");
        return this;
    }

    public FramePage enterTextInFrameArea(String value) {
        switchToFrame("mce_0_ifr");
        sendKeys(textField, value, VISIBLE, "");
        return this;
    }

    public String getTextFromFrameField() {
        return getText(textField, VISIBLE, "");
    }
}
