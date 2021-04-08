package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class JavascriptAlertsPage {
    public JavascriptAlertsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Click for JS Alert']")
    public WebElement JSalert;

    @FindBy(xpath = "//*[text()='Click for JS Confirm']")
    public WebElement JSconfirm;

    @FindBy(xpath = "//*[text()='Click for JS Prompt']")
    public WebElement JSprompt;

    @FindBy(id = "result")
    public WebElement result;
}
