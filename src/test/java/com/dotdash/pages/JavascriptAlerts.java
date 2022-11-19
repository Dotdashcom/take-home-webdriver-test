package com.dotdash.pages;

import annotations.NotVisible;
import annotations.Url;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

import java.util.List;

@Url("/javascript_alerts")
public class JavascriptAlerts extends WebPage {

    @FindBy(css = "li > button")
    private List<WebElement> alertButtons;

    @NotVisible
    @FindBy(id = "result")
    private WebElement resultText;

    public Alert clickAlertButton() {
        click(alertButtons.get(0));
        return switchToAlert();
    }

    public Alert clickConfirmButton() {
        click(alertButtons.get(1));
        return switchToAlert();
    }

    public Alert clickPromptButton() {
        click(alertButtons.get(2));
        return switchToAlert();
    }

    public String getResultText() {
        return getText(resultText);
    }
}
