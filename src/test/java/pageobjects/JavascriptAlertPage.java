package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class JavascriptAlertPage {

    private static JavascriptAlertPage _instance = null;
    private final By jsAlert = By.cssSelector("div.example li:first-of-type button");
    private final By jsConfirm = By.cssSelector("div.example li:nth-of-type(2) button");
    private final By jsPrompt = By.cssSelector("div.example li:last-of-type button");
    private final By jsPromptTextBox = By.cssSelector("#result");

    private final By resultMessageLabel = By.id("result");

    public static JavascriptAlertPage getInstance() {
        if (_instance == null)
            _instance = new JavascriptAlertPage();
        return _instance;
    }

    public void clickJSAlert() {
        ActionHelper.click(jsAlert);
    }

    public void clickJSConfirm() {
        ActionHelper.click(jsConfirm);

    }

    public void clickJSPrompt() {
        ActionHelper.click(jsPrompt);

    }

    public String getJSAlertMessage() {
        return ActionHelper.getAlertText();
    }

    public String getJSConfirmMessage() {
        return ActionHelper.getAlertText();
    }

    public String getJSPromptMessage() {
        return ActionHelper.getText(jsPromptTextBox).replace("You entered:", "").trim();
    }

    public void alertAccept() {
        ActionHelper.alertAccept();
    }

    public String getTextResultMessageLabel() {
        return ActionHelper.getText(resultMessageLabel);
    }

    public void fillJsPrompt(String value) {
        ActionHelper.fillAlertText(value);
    }
}