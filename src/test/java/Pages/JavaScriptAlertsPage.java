package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JavaScriptAlertsPage {
    public JavaScriptAlertsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement clickjsbutton;
    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement confirmbutton;
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement promptbutton;
    @FindBy(id = "result")
    public WebElement alerttext;



}
