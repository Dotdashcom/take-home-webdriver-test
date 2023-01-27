package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class NotificationMessagePage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public NotificationMessagePage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);

    }
    public void verifyNotification(){
        navigateToNotificationPage();
    }

    private void navigateToNotificationPage(){
        driver.get(ConfigReader.getProperty("url")+"/notification_message_rendered");
    }
}
