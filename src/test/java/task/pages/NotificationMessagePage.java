package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

public class NotificationMessagePage {


    public NotificationMessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(linkText = "Click here")
    public WebElement notificationLink;

    @FindBy(id = "flash")
    public WebElement messageBox;

}
