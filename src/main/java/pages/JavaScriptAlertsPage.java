package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage {

    private WebDriver driver;

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement JSAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement JSConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement JSPromptButton;

    @FindBy(xpath = "//p[@id='result']")
    private WebElement resultMessage;

    public String clickJavaScriptAlert() {
        JSAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public String clickJavaScriptConfirm() {
        JSConfirmButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void clickJavaScriptPrompt(String message) {
        JSPromptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
        alert.accept();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }
}
