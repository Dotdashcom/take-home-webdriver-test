package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy (xpath = "//button[.='Click for JS Alert']")
    public WebElement jsAlertBtn;

    @FindBy (xpath = "//button[.='Click for JS Confirm']")
    public WebElement confirmAlertBtn;

    @FindBy (xpath = "//button[.='Click for JS Prompt']")
    public WebElement promptAlertBtn;

    @FindBy (id = "result")
    public WebElement resultText;

}
