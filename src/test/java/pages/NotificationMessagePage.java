package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NotificationMessagePage {

    public NotificationMessagePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement header;

    @FindBy(xpath = "//a[@href='/notification_message']")
    public WebElement clickBtn;

    @FindBy(id="flash")
    public WebElement message;
}
