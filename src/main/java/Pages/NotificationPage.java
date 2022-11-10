package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {

    @FindBy(xpath = "//a[.='Click here']")
    public WebElement clickButton;

    @FindBy(xpath = "//div[@class='flash notice']")
    public WebElement Message;

    public NotificationPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

}