import PageObjects.HomePage;
import PageObjects.NotificationMessagePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static library.Constants.NotificationMessage.ACTION_SUCCESSFUL_MESSAGE;
import static library.Constants.NotificationMessage.ACTION_UNSUCCESSFUL_MESSAGE;

public class NotificationMessageTest {

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void validateNotifications()  {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.NOTIFICATION_LINKTEXT);
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        int successMessageCount =0;
        int unsuccessMessageCount =0;
        do{
            notificationMessagePage.clickOnClickHere();
           String message =  notificationMessagePage.getFashMessage();
           if(message.contains(ACTION_SUCCESSFUL_MESSAGE)) {
               successMessageCount++;
           }
            if(message.contains(ACTION_UNSUCCESSFUL_MESSAGE)) {
                unsuccessMessageCount++;
            }
        } while(successMessageCount==0 || unsuccessMessageCount ==0 );

    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
