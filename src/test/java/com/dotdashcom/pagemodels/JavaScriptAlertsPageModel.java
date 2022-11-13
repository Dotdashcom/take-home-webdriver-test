package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPageModel extends PageObject {

    public static final String PAGE_URL = "/javascript_alerts";

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement alertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement promptButton;

    @FindBy(id = "result")
    private WebElement resultParagraphElement;

    public JavaScriptAlertsPageModel(WebDriver driver) {
        super(driver);
    }

    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public WebElement getPromptButton() {
        return promptButton;
    }

    public WebElement getResultParagraphElement() {
        return resultParagraphElement;
    }
}
