package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JSAlertPage {
    public WebDriver driver;

    public JSAlertPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='Click for JS Alert']")
    private WebElement jsAlert;

    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    private WebElement jsConfirmAlert;

    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    private WebElement jsPromptAlerts;

    @FindBy(id = "result")
    private WebElement result;




    public boolean validateTextValue(String text) throws InterruptedException {

        return result.getText().toLowerCase().contains(text.toLowerCase());
    }


    public void clickJSAlert(){
        Helpers.ClickElement(jsAlert);
    }
    public void clickJSConfirmAlert(){
        Helpers.ClickElement(jsConfirmAlert);
    }
    public void clickJSPromptAlert(){
        Helpers.ClickElement(jsPromptAlerts);
    }

    public void selectAlertOption(String text){

        if (text.equalsIgnoreCase("accept")){
            Helpers.AcceptAlert();
        }
        else{
            Helpers.DismissAlert();
        }
    }

    public void writeOnPromptAlert(String text) throws InterruptedException {

        Helpers.PromptAlert(text);

    }
}
