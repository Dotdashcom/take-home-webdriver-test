package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePageObj extends CommonMethods {

    public NotificationMessagePageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(linkText = "Click here")
    private WebElement linkText;

    @FindBy(id = "flash")
    private WebElement flash;

    public WebElement getLinkText(){
        return linkText;
    }

    public WebElement errorText(){
        return flash;
    }


}
