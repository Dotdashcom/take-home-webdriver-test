package webdrivertestpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlert{
    WebDriver driver;
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement jsAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement jsConfirm;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement jsPrompt;

    String jsAlertTxt;
    String jsConfirmTxt;
    String jsPromptTxt;
    Alert alert;

    public JavaScriptAlert(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void javaScriptAl(){
        jsAlert.click();
        alert = driver.switchTo().alert();
        jsAlertTxt = alert.getText();
        alert.accept();

        jsConfirm.click();

        jsConfirmTxt = alert.getText();
        alert.dismiss();

        jsPrompt.click();
        alert.sendKeys("MiftahChowdhury");

        jsPromptTxt = alert.getText();
        alert.accept();
    }

    public String getJsAlertTxt(){
        return jsAlertTxt;
    }

    public String getJsConfirmTxt(){
        return jsConfirmTxt;
    }

    public String getJsPromptTxt(){
        return jsPromptTxt;
    }
}
