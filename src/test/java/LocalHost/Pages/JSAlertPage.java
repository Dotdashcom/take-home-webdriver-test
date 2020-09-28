package LocalHost.Pages;

import LocalHost.Utilities.BrowserUtils;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JSAlertPage {
    public JSAlertPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@onclick='jsAlert()']")
    private WebElement alertButton;

    @FindBy(xpath = "//*[@onclick='jsConfirm()']")
    private WebElement acceptJS;

    @FindBy(xpath="//*[@onclick='jsPrompt()']")
    private WebElement typeJS;

    @FindBy(id = "result")
    private WebElement result;



    public void jsAlert(){
        alertButton.click();
        Assert.assertTrue(AlertConfirmation());
    }

    public void acceptAlert(){
        acceptJS.click();
        Alert alert=Driver.getDriver().switchTo().alert();
        BrowserUtils.waitFor(4);
        alert.accept();
        Assert.assertTrue(AlertConfirmation());
    }

    public void SendMessage(){
        typeJS.click();
        String str="This is my JS Message!!!";
        Alert alert=Driver.getDriver().switchTo().alert();
        Driver.getDriver().switchTo().alert().sendKeys(str);
        alert.accept();
        BrowserUtils.waitFor(4);
        Assert.assertTrue(result.getText().contains(str));
    }

    public boolean AlertConfirmation(){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3 );
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }
}
