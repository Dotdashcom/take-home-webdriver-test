package com.assignments.pages;

import org.apache.commons.compress.archivers.sevenz.CLI;
import org.openqa.selenium.By;

import java.util.PrimitiveIterator;

import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class DynamicControlPage extends BasePage {
    private final By removeButton = By.xpath("//button[text()='Remove']");
    private final By addButton = By.xpath("//button[text()='Add']");
    private final By enabledMessage = By.xpath("//p[contains(text(), 'enabled')]");
    private final By checkBox = By.xpath("//input[@id='checkbox']");
    private final By enableButton = By.xpath("//button[text()='Enable']");
    private final By disableButton = By.xpath("//button[text()='Disable']");
    private final By textBox = By.xpath("//input[@type='text']");

    private final By disabledMessage = By.xpath("//p[contains(text(), 'disabled')]");

    public DynamicControlPage clickOnRemove() {
        click(removeButton, CLICKABLE, "Remove Button");
        return this;
    }

    public boolean isCheckBoxDisplayed() {
        return isDisplayed(checkBox, VISIBLE, "Check Box");
    }

    public DynamicControlPage clickOnAdd() {
        click(addButton, CLICKABLE, "Add Button");
        return this;
    }

    public DynamicControlPage clickOnEnableButton() {
        click(enableButton, CLICKABLE, "Enable Button");
        return this;
    }

    public boolean isTextBoxEnabled() {
        return isEnabled(textBox, VISIBLE, "Text Box");
    }

    public DynamicControlPage clickOnDisabledButton() {
        click(disableButton, CLICKABLE, "Disable Button");
        return this;
    }

    public boolean isEnabledMessageDisplayed() {
        return isDisplayed(enabledMessage, VISIBLE,"Enabled Message");
    }

    public boolean isDisabledMessageDisplayed() {
        return isDisplayed(disabledMessage, VISIBLE, "Disabled Message");
    }
}
