package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Click for JS Alert']")
    public WebElement simpleAlertButton;

    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    public WebElement confirmAlertButton;

    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    public WebElement promptAlertButton;

    @FindBy(id = "result")
    public WebElement result;
}
