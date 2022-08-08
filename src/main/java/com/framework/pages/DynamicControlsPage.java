package com.framework.pages;

import com.framework.utils.Utils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends PageObjectBase {

    @FindBy(xpath = "//form[@id='checkbox-example']/button[text() = 'Remove' or text() = 'Add']")
    WebElement removeOrAddButton;

    @FindBy(xpath = "//form[@id='checkbox-example']/p[@id='message']")
    WebElement checkBoxFormMessage;

    @FindBy(xpath = "//form[@id='input-example']/button[text() = 'Disable' or text() = 'Enable']")
    WebElement disableOrEnableButton;

    @FindBy(xpath = "//form[@id='input-example']/p[@id='message']")
    WebElement inputFormMessage;


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/dynamic_controls");
        return this;
    }

    private void clickRemoveOrAddButton() {
        removeOrAddButton.click();
    }

    public void clickRemoveButton() {
        clickRemoveOrAddButton();
    }

    public void clickAddButton() {
        clickRemoveOrAddButton();
    }

    private void clickDisableOrEnableButton() {
        disableOrEnableButton.click();
    }

    public void clickDisableButton() {
        clickDisableOrEnableButton();
    }

    public void clickEnableButton() {
        clickDisableOrEnableButton();
    }

    private String getMessage(String xPath, WebElement messageElement) {
        String message = "";
        try {
            Utils.explicitWait(driver, xPath, 20);
            message = messageElement.getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return message;
    }

    public String waitAndGetCheckBoxFormMessage() {
        return getMessage("//form[@id='checkbox-example']/p[@id='message']", checkBoxFormMessage);
    }

    public String waitAndGetInputFormMessage() {
        return getMessage("//form[@id='input-example']/p[@id='message']", inputFormMessage);
    }

}
