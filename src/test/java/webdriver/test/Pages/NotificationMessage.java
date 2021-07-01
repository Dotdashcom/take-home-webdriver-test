package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;


public class NotificationMessage {

    //local webdriver variable
    private WebDriver driver;

    @FindBy(xpath = "//a[.='Click here']")
    public WebElement notificationLink;

    @FindBy(id = "flash")
    public WebElement flashMessage;

    //Page Class Constructor
    public NotificationMessage(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void clickNotificationLink() {
        notificationLink.click();
    }


    public void checkNotificationMessageUnsuccessful () {

    }



    public void checkNotificationMessageArray() {

    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/notification_message_rendered");
    }
}
