package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class JavaScriptAlertPage extends TestBase {
    @FindBy(css = "[onclick='jsAlert()']")
    WebElement alertBtn;
    @FindBy(css = "[onclick='jsConfirm()']")
    WebElement confirmBtn;
    @FindBy(css = "[onclick='jsPrompt()']")
    WebElement promptBtn;
    @FindBy(id = "result")
    WebElement resultMessage;
    public JavaScriptAlertPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public void clickAlertBtn() {
        alertBtn.click();
    }

    public void clickConfirmBtn() {
        confirmBtn.click();
    }

    public void clickPromptBtn() {
        promptBtn.click();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }

}
