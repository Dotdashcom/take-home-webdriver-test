package model;

import model.base.BasePage;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavascriptAlertPage extends BasePage {

    private static final String JS_ALERTS_ENDPOINT = "javascript_alerts";

    @FindBy(css = "ul li:nth-child(1) button")
    private WebElement JSAlertButton;

    @FindBy(css = "ul li:nth-child(2) button")
    private WebElement JSConfirmButton;

    @FindBy(css = "ul li:nth-child(3) button")
    private WebElement JSPromptButton;

    @FindBy(css = "#result")
    private WebElement alertActionConfirmation;

    public JavascriptAlertPage(WebDriver driver) {
        super(driver);
    }

    public JavascriptAlertPage getJavascriptAlertPage(){
        getDriver(JS_ALERTS_ENDPOINT);

        return this;
    }

    public JavascriptAlertPage clickJSAlertButton(){
        JSAlertButton.click();

        return this;
    }

    public JavascriptAlertPage clickJSConfirmButton(){
        JSConfirmButton.click();

        return this;
    }

    public JavascriptAlertPage clickJSPromptButton(){
        JSPromptButton.click();

        return this;
    }

    public JavascriptAlertPage clickOKJSAlert(){
        getDriver().switchTo().alert().accept();

        return this;
    }

    public JavascriptAlertPage clickCancelJSAlert(){
        getDriver().switchTo().alert().dismiss();

        return this;
    }

    public String getTextJSAlert(){

        return getDriver().switchTo().alert().getText();
    }

    public JavascriptAlertPage inputTextJSAlert(String textToEnter){
        getDriver().switchTo().alert().sendKeys(textToEnter);

        return this;
    }

    public String getAlertActionConfirmationMessageText(){

        return alertActionConfirmation.getText();
    }

    public boolean isAlertPresent(){
        try {
            getDriver().switchTo().alert();
            return true;
        } catch(NoAlertPresentException e){
            e.fillInStackTrace();
            return false;
        }
    }
}