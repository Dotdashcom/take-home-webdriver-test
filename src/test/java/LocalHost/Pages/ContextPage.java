package LocalHost.Pages;

import LocalHost.Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContextPage {
    public ContextPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@oncontextmenu='displayMessage()']")
    private WebElement context;


    public void Context_Click(){
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(context).perform();
    }

    public void Accept_Message(){
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    public void VerifyAlertText(){
       String str= Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(str,"You selected a context menu");
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
