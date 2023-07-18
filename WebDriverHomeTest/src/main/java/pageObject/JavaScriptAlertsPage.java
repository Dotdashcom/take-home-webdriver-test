package pageObject;

import base.CommonApi;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage extends CommonApi {
    WebDriver driver;
    public JavaScriptAlertsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[text()='Click for JS Alert']")
     WebElement jsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement jsPromptButton;

    @FindBy(xpath = "//p[@id='result']")
    WebElement message;

    public void jsAlert(){
        jsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void  jsConfirm(){
        jsConfirmButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void jsPrompt(){
        jsPromptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("message");
        alert.accept();
    }
    public String getMessage(){
        return message.getText();
    }
     public void goTo(){
        driver.get(" http://localhost:7080/javascript_alerts");
     }
}
