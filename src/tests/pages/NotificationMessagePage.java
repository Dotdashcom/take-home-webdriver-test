package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationMessagePage {

    public WebDriver driver;

    @FindBy(linkText = "Click here")
    public WebElement link_ClickHere;

    @FindBy(id = "flash")
    public WebElement text_NotoficationMessage;

    public NotificationMessagePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyNewTabDisplay(){
        String[] messages = {"Action Successful", "Action unsuccessful, please try again", "Action Unsuccessful"};
        for(int i=0;i<10;i++) {
            link_ClickHere.click();
            Assert.assertTrue(text_NotoficationMessage.isDisplayed()&&
                    Arrays.asList(messages).contains(text_NotoficationMessage.getAttribute("text").trim()), "Notification message not displayed as expected.");
        }
    }

}
