package takehome.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.Driver;

public class JSAlertPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    public JSAlertPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "JavaScript Alerts")
    public WebElement jsScriptLink;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement JsAlertBtn;
    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement jsConfirmBtn;
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement jsPromptBtn;

    public void switchToAlert(){

        Driver.getDriver().switchTo().alert();
    }
    public String returnJsTxt(){
        Alert alert = Driver.getDriver().switchTo().alert();
       wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
    public void clickOnJsButton(WebElement element){
        element.click();
    }
    public void clickOnJsLink(){
        wait.until(ExpectedConditions.elementToBeClickable(jsScriptLink ));
        jsScriptLink.click();
    }


}
