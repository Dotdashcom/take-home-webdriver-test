package com.assignments.pages;

import org.openqa.selenium.By;
import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class JSAlertPage extends BasePage {

    private final By jsPrompt = By.cssSelector("button[onclick='jsPrompt()']");

    private final By jsAlert = By.cssSelector("button[onclick='jsAlert()']");

    private final By jsConfirm = By.cssSelector("button[onclick='jsConfirm()']");

    private final By resultText = By.cssSelector("#result");

    public String validateJSAlertResult() {
        click(jsAlert, CLICKABLE, "Alert Dialog");
        switchToAlert().accept();
        return getText(resultText, VISIBLE, "Result ALert Dialog");
    }

    public String validateJSConfirmResult() {
        click(jsConfirm, CLICKABLE, "Confirm Dialog");
        switchToAlert().accept();
        return getText(resultText, VISIBLE, "Result Confirm Dialog");
    }

    public String validateJSPromptResult(String value) {
        click(jsPrompt, CLICKABLE, "Prompt");
        switchToAlert().sendKeys(value);
        switchToAlert().accept();
        return getText(resultText, VISIBLE, "Result Prompt");
    }
}
