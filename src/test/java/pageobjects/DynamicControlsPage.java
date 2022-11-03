package pageobjects;

import actions.ActionHelper;
import org.openqa.selenium.By;

public class DynamicControlsPage extends CommonPage{

    private static DynamicControlsPage _instance = null;
    private final By removeOrAddButton = By.xpath("//form[@id='checkbox-example']/button");
    private final By checkBox = By.id("checkbox");
    private final By messageLabel = By.id("message");
    private final By enableDisableButton = By.xpath("//form[@id='input-example']/button");
    private final By textBox = By.cssSelector("div.example #input-example input");


    public static DynamicControlsPage getInstance() {
        if (_instance == null)
            _instance = new DynamicControlsPage();
        return _instance;
    }

    public void ClickRemoveOrAddButton() {
        ActionHelper.click(removeOrAddButton);
    }

    public boolean isCheckBoxDisplayed() {
        return ActionHelper.isPresent(checkBox);
    }

    public String getMessageLabelText() {
        return ActionHelper.getText(messageLabel);
    }

    public void clickEnableDisableButton() {
        ActionHelper.click(enableDisableButton);
    }

    public boolean isTextBoxEnabled() {
        return ActionHelper.isEnabled(textBox);
    }
}