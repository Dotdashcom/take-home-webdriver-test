package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

public class JavaScriptAlertsPage {


    public JavaScriptAlertsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement jsAlert;


    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement jsConfirm;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement jsPrompt;

    @FindBy(id = "result")
    public WebElement result;






}
