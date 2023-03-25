package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;

import java.io.File;
import java.io.IOException;

public class NotificationMessagePageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "notificationMessageUrl", "notificationMessage","times"})
    public void notification_Message_Test(String baseUrl, String notificationMessageUrl, String notificationMessage, String times) throws NumberFormatException, IOException {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        notificationMessagePage.goToUrl(baseUrl , notificationMessageUrl);
        try {
        for (int i = 0; i < Integer.parseInt(times); i++) {
            notificationMessagePage.clickLink();
            Assert.assertTrue(notificationMessagePage.checkMessagesValid(notificationMessage));
        }
        }catch (AssertionError e) {
            // handle the assertion failure
            System.out.println("The test failed with the following error message: " + e.getMessage());
            // take a screenshot of the browser
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("error.png"));
            // fail the test case
            Assert.fail("The test failed with the following actual result: " + notificationMessagePage.getMessage());
        }
    }
}
