package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAllertsPage extends BasePage {

    @FindBy (xpath = "//button[text()='Click for JS Alert']")
    public WebElement JSAlertButton;

    @FindBy (xpath = "//button[text()='Click for JS Confirm']")
    public WebElement JSConfirmButton;

    @FindBy (xpath = "//button[text()='Click for JS Prompt']")
    public WebElement JSPrompt;

    @FindBy(css = "#result")
    public WebElement result;

}
