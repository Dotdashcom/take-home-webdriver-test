package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JavaScriptAlertsPage {
    public JavaScriptAlertsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//button)[1]")
    public WebElement alertButton;

    @FindBy(xpath = "(//button)[2]")
    public WebElement confirmButton;

    @FindBy(xpath = "(//button)[3]")
    public WebElement promptButton;

    @FindBy(id = "result")
    public WebElement resultText;
}
