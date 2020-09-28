package takehome.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.BrowserUtilities;
import takehome.utilities.Driver;

public class LoginPage {
@FindBy(linkText = "Form Authentication")
private WebElement formAuthLink;
@FindBy (id = "username")
private WebElement username;
@FindBy(id = "password")
private WebElement password;
@FindBy(id = "flash-messages")
private WebElement successfulLoginMsg;
@FindBy(xpath = "//h4[@class='subheader']")
private WebElement welcomeMessage;
@FindBy(id = "flash-messages")
private WebElement incorrectMessageNotification;
@FindBy(id = "hot-spot")
private WebElement contextMenu;
@FindBy(linkText = "Context Menu")
private WebElement contextMenuLink;

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }
    public void clickOnLoginLink(){
        formAuthLink.click();
    }
    public  String getWelcomeMessage() throws InterruptedException {
        Thread.sleep(5000);
        return successfulLoginMsg.getText().trim();
    }
    public String getInvalidPasswordMessage(){
        return incorrectMessageNotification.getText().trim();
    }


    public LoginPage() {


        PageFactory.initElements(Driver.getDriver(), this);
    }
    public String getLoginSuccessMessage(){


        return  welcomeMessage.getText();
    }

    public String rightClickONContextMenu(){

        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(contextMenu).perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        return alert.getText();
    }
    public void clickOnContextLink(){
        contextMenuLink.click();
    }
}
