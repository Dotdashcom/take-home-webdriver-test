package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class JSAlertPage extends BasePage{

    public JSAlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement jsAlert;

    @FindBy(xpath = "//p[@id='result']")
    public WebElement tMessage;


    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement confirmBtn;


    @FindBy(xpath ="//button[@onclick='jsPrompt()']" )
    public WebElement promBtn;


}
