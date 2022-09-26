package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_018_NotificationMessage extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/notification_message_rendered");
    }

    @Test
    public void TC001_NotificationTesting() {
        List<String> errorExpected = new ArrayList<>(Arrays.asList("Action Successful", "Action unsuccessful, please try again", "Action unsuccessful"));

        int i = 0;
        do {
            nm.getLinkText().click();
            String errorText = nm.errorText().getText();

            if (errorText.equals(errorExpected.get(i))) {
                i++;
                Assert.assertTrue(errorText.contains(errorExpected.get(i)));
            }
        } while (false);
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
