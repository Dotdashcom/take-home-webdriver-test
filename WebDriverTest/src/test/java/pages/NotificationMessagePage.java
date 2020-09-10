package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends Functions {

    @FindBy(css = "a[href^='/notific']")
    public WebElement linkToMessage;

    @FindBy(id = "flash")
    public WebElement notificationMessage;



    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public NotificationMessagePage() {

        PageFactory.initElements(driver, this);

    }
}
