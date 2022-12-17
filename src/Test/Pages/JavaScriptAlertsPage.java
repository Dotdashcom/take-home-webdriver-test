package Pages;

import Utils.Driver;
import Utils.HelpfulMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage {
    public JavaScriptAlertsPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(css = "li:nth-child(1) > button")
    private WebElement jsAlertBox;

    @FindBy(xpath = "//p[@id='result']")
    private WebElement verificationMessage;

    @FindBy(xpath = "(//button)[2]")
    private WebElement jsConfirmButton;

    @FindBy(xpath = "(//button)[3]")
    private WebElement jsPromptButton;
    public void setJsAlertBox(){
        jsAlertBox.click();
        Driver.GetDriver().switchTo().alert().getText().contains("I am a JS Alert");
        HelpfulMethods.staticWait(5);
        Driver.GetDriver().switchTo().alert().dismiss();
        HelpfulMethods.staticWait(5);
        Driver.GetDriver().switchTo().defaultContent();

    }
    public void setJsConfirmButtonBox(){
        jsConfirmButton.click();
        Driver.GetDriver().switchTo().alert().getText().contains("I am a JS Confirm");
        HelpfulMethods.staticWait(5);
        Driver.GetDriver().switchTo().alert().accept();
        HelpfulMethods.staticWait(5);
        Driver.GetDriver().switchTo().defaultContent();

    }
    public void setJsPromptButton(String text){
        jsPromptButton.click();
        Driver.GetDriver().switchTo().alert().sendKeys(text);
        HelpfulMethods.staticWait(5);
        Driver.GetDriver().switchTo().alert().accept();
        HelpfulMethods.staticWait(5);
        Driver.GetDriver().switchTo().defaultContent();

    }
    public String VerificationMessage(){
        return verificationMessage.getText();
    }
}
