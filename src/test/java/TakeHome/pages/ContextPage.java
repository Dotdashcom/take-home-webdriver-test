package TakeHome.pages;

import TakeHome.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextPage {
    public ContextPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//*[@oncontextmenu='displayMessage()']")
    private WebElement context;


    public void contextClick(){
        Actions actions = new Actions(Driver.get());
        actions.contextClick(context).perform();
    }

    public void acceptMessage(){
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }

    public String getAlertText(){
       return Driver.get().switchTo().alert().getText();
    }

    public boolean verifyAlertDisplayed(){
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
}
