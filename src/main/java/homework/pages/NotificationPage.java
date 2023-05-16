package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {

    public NotificationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(linkText = "Click here")
    public WebElement clickHereLink;

    @FindBy(id = "flash")
    public WebElement messages;




}
