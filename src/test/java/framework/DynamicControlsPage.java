package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(), 'Remove')]")
    WebElement removeButton;

    @FindBy(xpath = "//p[@id='message']")
    WebElement message;

    @FindBy(xpath = "//button[contains(text(), 'Add')]")
    WebElement addButton;

    @FindBy(xpath = "//button[contains(text(), 'Enable')]")
    WebElement enableButton;

    @FindBy(xpath = "//button[contains(text(), 'Disable')]")
    WebElement disableButton;

    @FindBy (xpath = "//input[@type='text']")
    WebElement inputField;


    public DynamicControlsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean checkRemoveButton(WebDriver driver) {
        clickOnElement(driver, removeButton, "Success: Clicked on Remove button",
                "Failed: Unable to click on Remove button");
        waitUntilElementIsPresent(driver, message);
        if (!isElementPresent(driver, removeButton)) {
            return true;
        }
        return false;
    }

    public boolean checkAddButton(WebDriver driver) {
        clickOnElement(driver, addButton, "Success: Clicked on Add button",
                "Failed: Unable to click on Add button");
        waitUntilElementIsPresent(driver, message);
        if (isElementPresent(driver, removeButton)) {
            return true;
        }
        return false;
    }

    public boolean checkEnableButton(WebDriver driver) {
        clickOnElement(driver, enableButton, "Success: Clicked on Enable button",
                "Failed: Unable to click on Enable button");
        waitUntilElementIsPresent(driver, message);
        if (inputField.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean checkDisableButton(WebDriver driver) {
        clickOnElement(driver, disableButton, "Success: Clicked on Disable button",
                "Failed: Unable to click on Disable button");
        waitUntilElementIsPresent(driver, message);
        if (!inputField.isEnabled()) {
            return true;
        }
        return false;
    }
}
