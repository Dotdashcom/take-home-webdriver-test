package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage extends Base {
    WebDriver driver;

    By alertButton = By.xpath(readValue("javascriptAlertsPage.jsAlertXp"));
    By confirmButton = By.xpath(readValue("javascriptAlertsPage.jsConfirmXp"));
    By promptButton = By.xpath(readValue("javascriptAlertsPage.jsPrompt"));
    By resultText = By.xpath(readValue("javascriptAlertsPage.resultTextXP"));

    public void clickAlertButton() {
        driver.findElement(alertButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void clickPromptButton() {
        driver.findElement(promptButton).click();
    }

    public String jsMessage() {
        String msg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return msg;
    }

    public void jsPromptSendText(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public boolean resultContainsText(String text) {
        String result = driver.findElement(resultText).getText();
        return result.contains(text);
    }

    public JSAlertsPage(WebDriver driver) {
        this.driver = driver;
    }
}
