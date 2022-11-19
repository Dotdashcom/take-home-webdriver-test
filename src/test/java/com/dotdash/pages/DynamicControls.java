package com.dotdash.pages;

import annotations.NotVisible;
import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/dynamic_controls")
public class DynamicControls extends WebPage {

    @NotVisible
    @FindBy(id = "checkbox")
    private WebElement checkbox;

    @FindBy(css = "#checkbox-example > button")
    private WebElement addRemoveCheckboxButton;

    @NotVisible
    @FindBy(css = "#checkbox-example > #message")
    private WebElement checkboxOperationMessage;

    @FindBy(css = "#input-example > input")
    private WebElement inputField;

    @FindBy(css = "#input-example > button")
    private WebElement enableDisableInputButton;

    @NotVisible
    @FindBy(css = "#input-example  > #message")
    private WebElement inputOperationMessage;

    @NotVisible
    @FindBy(id = "loading")
    private WebElement loadingMessage;

    public boolean isCheckboxDisplayed() {
        return isVisible(checkbox, 5);
    }

    public DynamicControls addRemoveCheckbox(String operation) {
        if (getText(addRemoveCheckboxButton).equalsIgnoreCase(operation)) {
            click(addRemoveCheckboxButton);
        }
        return this;
    }

    public String getCheckboxOperationMessage() {
        return getText(checkboxOperationMessage, 5);
    }

    public boolean isInputEnabled() {
        return isEnabled(inputField, 5);
    }

    public DynamicControls enableDisableInput(String operation) {
        if (getText(enableDisableInputButton).equalsIgnoreCase(operation)) {
            click(enableDisableInputButton);
        }
        waitForLoading();
        return this;
    }

    public String getInputOperationMessage() {
        return getText(inputOperationMessage, 5);
    }

    private void waitForLoading() {
        isNotDisplayed(loadingMessage, 5);
    }

}
