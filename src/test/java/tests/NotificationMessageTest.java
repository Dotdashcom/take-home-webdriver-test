package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.NotificationMessage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NotificationMessageTest extends BasePage {

    NotificationMessage nm;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.notificationMessage);
        nm=new NotificationMessage();
    }
    @Test
    public void JavaScriptError(){
        Assert.assertTrue(nm.notificationMessagesDisplayed());
    }
    @AfterTest
    public void tearDown()
    {
        quit();
    }
}
