package Pages;

import Utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends TestBase {

    public NotificationMessagePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//a[.='Click here']")
    public WebElement clickHereLink;

    @FindBy(id = "flash")
    public WebElement notificationMessage;
}
