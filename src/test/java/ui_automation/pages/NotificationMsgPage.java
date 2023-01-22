package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class NotificationMsgPage extends BasePage{

    public NotificationMsgPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text() ='Click here']")
    public WebElement clickHere;


    @FindBy(xpath = "//div[@id='flash']")
    public WebElement realMsg;



}
