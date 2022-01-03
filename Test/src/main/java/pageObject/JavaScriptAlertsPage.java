package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    WebDriver webDriver;
    String javaScriptAlertsPageUrl = "http://localhost:7080/javascript_alerts";
    String jsAlertButtonXpath = "//button[@onclick='jsAlert()']";
    String jsConfirmButtonXpath = "//button[@onclick='jsConfirm()']";
    String jsPromptButtonXpath = "//button[@onclick='jsPrompt()']";
    String resultXpath = "//p[@id='result']";


    public JavaScriptAlertsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(javaScriptAlertsPageUrl);
    }

    public void clickJSAlertButton(){
        webDriver.findElement(By.xpath(jsAlertButtonXpath)).click();
    }

    public void clickJSConfirmButton(){
        webDriver.findElement(By.xpath(jsConfirmButtonXpath)).click();
    }

    public void clickJSPromptButton(){
        webDriver.findElement(By.xpath(jsPromptButtonXpath)).click();
    }

    public String getAlertText(){
        return webDriver.switchTo().alert().getText();
    }

    public void closeAlert(){
        webDriver.switchTo().alert().accept();
    }

    public void enterOnAlert(String text){
        webDriver.switchTo().alert().sendKeys(text);
    }

    public String getResult(){
        return webDriver.findElement(By.xpath(resultXpath)).getText();
    }
}
