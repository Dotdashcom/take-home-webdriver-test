package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSAlertsPageObject extends BasePageObject {
    @FindBy(css = "button[onclick='jsPrompt()']")
    private WebElement jsPrompt;
    @FindBy(css = "button[onclick='jsConfirm()']")
    private WebElement jsConfirm;
    @FindBy(css = "button[onclick='jsAlert()']")
    private WebElement jsAlert;
    @FindBy(id = "result")
    private WebElement result;

    public JSAlertsPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }
    public JSAlertsPageObject clickAlert(){
        jsAlert.click();
        return this;
    }
    public JSAlertsPageObject clickConfirm(){
        jsConfirm.click();
        return this;
    }
    public JSAlertsPageObject clickPrompt(){
        jsPrompt.click();
        return this;
    }
    public String getAlertText(){
       return getDriver().switchTo().alert().getText();
    }
    public JSAlertsPageObject acceptAlert(){
        getDriver().switchTo().alert().accept();
        return this;
    }
    public JSAlertsPageObject enterTextToAlert(String text){
        getDriver().switchTo().alert().sendKeys(text);
        return this;
    }
    public String getResultText(){
        return result.getText();
    }
}
