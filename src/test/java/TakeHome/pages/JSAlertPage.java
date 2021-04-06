package TakeHome.pages;

import TakeHome.utilities.BrowserUtils;
import TakeHome.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSAlertPage extends BasePage {
    public JSAlertPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[@onclick='jsAlert()']")
    private WebElement alertButton;

    @FindBy(xpath = "//*[@onclick='jsConfirm()']")
    private WebElement acceptJS;

    @FindBy(xpath="//*[@onclick='jsPrompt()']")
    private WebElement typeJS;

    @FindBy(id = "result")
    private WebElement result;



    public void clickJsAlertButton(){
        alertButton.click();
    }

    public void acceptAlert(){
        acceptJS.click();
        Alert alert=Driver.get().switchTo().alert();
        BrowserUtils.waitFor(4);
        alert.accept();
    }

    public void SendMessage(){
        typeJS.click();
        String str="This is my JS Message!!!";
        Alert alert=Driver.get().switchTo().alert();
        Driver.get().switchTo().alert().sendKeys(str);
        alert.accept();
        BrowserUtils.waitFor(4);
    }

    public String getSentJSMessage() {
        return result.getText();
    }

    public boolean alertConfirmationDisplayed(){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(Driver.get(), 3 );
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }

    public String getAlertText() {
        Alert alert=Driver.get().switchTo().alert();
        Driver.get().switchTo().alert();

        return alert.getText();
    }
}
