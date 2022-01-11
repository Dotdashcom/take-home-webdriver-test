package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    WebDriver driver;
    String JavaScriptAlertsUrl =("http://localhost:7080/javascript_alerts");
    String jsAlertXpath = "//button[@onclick='jsAlert()']";
    String jsConfirmXpath = "//button[@onclick='jsConfirm()']";
    String jsPromptXpath = "//button[@onclick='jsPrompt()']";
    By resultId = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(JavaScriptAlertsUrl);
    }
    public void clickJSAlert(){
        driver.findElement(By.xpath(jsAlertXpath)).click();
    }

    public void clickJSConfirmButton(){
        driver.findElement(By.xpath(jsConfirmXpath)).click();
    }

    public void clickJSPrompt(){
        driver.findElement(By.xpath(jsPromptXpath)).click();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }

    public void typeOnPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public String getEnteredText(){
        return driver.findElement(resultId).getText();
    }
}
