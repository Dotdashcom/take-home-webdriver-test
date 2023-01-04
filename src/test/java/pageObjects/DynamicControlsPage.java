package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicControlsPage extends Page {
    private static final By REMOVE_ADD_BUTTON = By.xpath("//form[@id='checkbox-example']/button");
    private static final By CHECKBOX = By.id("checkbox");
    private static final By TEXT_BOX = By.xpath("//form[@id='input-example']/input");
    private static final By ENABLE_DISABLE_BUTTON = By.xpath("//form[@id='input-example']/button");
    private static final By MESSAGE = By.id("message");

    private WebElement removeAddButtonElement;
    private WebElement enableDisableButtonElement;
    private WebElement textBoxElement;


    public DynamicControlsPage(ChromeDriver driver) {
        super(driver);
    }

    public DynamicControlsPage clickRemoveButton() {
        removeAddButtonElement = elementToBeClickable(REMOVE_ADD_BUTTON, BasePage.TIMEOUT);
        removeAddButtonElement.click();
        return this;
    }

    public DynamicControlsPage clickAddButton() {
        removeAddButtonElement.click();
        return this;
    }

    public boolean isCheckboxPresent() {
        return isElementLocatedVisible(CHECKBOX, BasePage.ACTION_TIMEOUT);
    }

    public String getMessageText() {
        return visibilityOfElementLocated(MESSAGE, BasePage.TIMEOUT).getText();
    }

    public DynamicControlsPage clickEnableButton() {
        enableDisableButtonElement = elementToBeClickable(ENABLE_DISABLE_BUTTON, BasePage.TIMEOUT);
        enableDisableButtonElement.click();
        return this;
    }

    public boolean isTextBoxEnabled() {
        textBoxElement = driver.findElement(TEXT_BOX);
        return textBoxElement.isEnabled();
    }

    public DynamicControlsPage clickDisableButton() {
        enableDisableButtonElement.click();
        return this;
    }

    public boolean isTextBoxDisabled() {
        return !textBoxElement.isEnabled();
    }
}
