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


    public DynamicControlsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkDynamicElements(WebDriver driver) {
        clickOnElement(driver, removeButton, "Success: Clicked on Remove button",
                "Failed: Unable to click on Remove button");
        waitUntilElementIsPresent(driver, message);
        clickOnElement(driver, addButton, "Success: Clicked on Add button",
                "Failed: Unable to click on Add button");
        waitUntilElementIsPresent(driver, message);
        clickOnElement(driver, enableButton, "Success: Clicked on Enable button",
                "Failed: Unable to click on Enable button");
        waitUntilElementIsPresent(driver, message);
        clickOnElement(driver, disableButton, "Success: Clicked on Disable button",
                "Failed: Unable to click on Disable button");
        waitUntilElementIsPresent(driver, message);
    }
}
