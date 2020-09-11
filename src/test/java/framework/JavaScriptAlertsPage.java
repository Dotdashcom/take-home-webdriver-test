package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'Click for JS Alert')]")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[contains(text(), 'Click for JS Confirm')]")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[contains(text(), 'Click for JS Prompt')]")
    WebElement jsPromptButton;

    @FindBy(xpath = "//p[contains(text(), 'You successfuly clicked an alert')]")
    WebElement jsAlertSuccessMsg;

    @FindBy(xpath = "//p[contains(text(), 'You clicked: Ok')]")
    WebElement jsConfirmOKSuccessMsg;

    @FindBy(xpath = "//p[contains(text(), 'You entered')]")
    WebElement jsPromptSuccessMsg;

    private String alertText = "Hello World";

    public JavaScriptAlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean testJavaScriptAlerts (WebDriver driver) {
        boolean jsAlertPassed = false;
        boolean jsConfirmPassed = false;
        boolean jsPromptPassed = false;
        boolean testPassed = false;
        clickOnElement(driver, jsAlertButton, "Success: Clicked on JS Alert button",
                "Failed: Unable to click on JS Alert button");
        alertAccept(driver);
        if (isElementPresent(driver, jsAlertSuccessMsg)) {
            jsAlertPassed = true;
        }
        clickOnElement(driver, jsConfirmButton, "Success: Clicked on JS Confirm button",
                "Failed: Unable to click on JS Confirm button");
        alertAccept(driver);
        if (isElementPresent(driver, jsConfirmOKSuccessMsg)) {
            jsConfirmPassed = true;
        }
        clickOnElement(driver, jsPromptButton, "Success: Clicked on JS Prompt button",
                "Failed: Unable to click on JS Prompt button");
        alertSendKeys(driver, alertText);
        alertAccept(driver);
        if (isElementPresent(driver, jsPromptSuccessMsg)) {
            jsPromptPassed = true;
        }
        if (jsAlertPassed && jsConfirmPassed && jsPromptPassed) {
            testPassed = true;
        }
        return testPassed;
    }
}
