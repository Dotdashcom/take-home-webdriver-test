package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JSAlertPage {

    public JSAlertPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement JSAlertBtn;

    @FindBy(id = "result")
    public WebElement message;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement JSConfirmAlertBtn;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement JSPromptAlertBtn;

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement header;

}
