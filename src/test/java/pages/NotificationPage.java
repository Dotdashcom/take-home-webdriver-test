package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NotificationPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "notification_message_rendered";
    //Link that opens in new tab
    @FindBy(linkText="Click here")
    private WebElement notificationLink;
    //Notification message
    @FindBy(css = ".notice")
    private WebElement notification;
    //Notification message close icon
    @FindBy(css = ".notice a.close")
    private WebElement notificationClose;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    private static int CLICK_ATTEMPTS = 5;

    private String[] expNotification = {"Action unsuccesful, please try again", "Action unsuccesful", "Action successful"};

    //Constructor
    public NotificationPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Notification Message");
    }

    //Verify notification
    public void verifyNotification() {
        while(CLICK_ATTEMPTS > 0) {
            notificationLink.click();
            String notificationText = notification.getText().replace(notificationClose.getText(),"").trim();
            assertTrue(Arrays.asList(expNotification).contains(notificationText));
            CLICK_ATTEMPTS--;
        }
    }
}
