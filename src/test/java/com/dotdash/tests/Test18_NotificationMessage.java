package com.dotdash.tests;

import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class Test18_NotificationMessage {

    /**
     * Test clicks on the Click Here link a multiple times.
     * Test asserts that one of the “Action successful”,
     * “Action unsuccesful, please try again” and
     * “Action unsuccessful” messages show on click.
     */

    @Test
    public void notificationMessageTest(){

        String url = ConfigurationReader.getProperty("base.url") + "/notification_message_rendered";
        Driver.getDriver().get(url);

        List<String> expectedResults = new ArrayList<>();
        expectedResults.add("Action successful");
        expectedResults.add("Action unsuccesful, please try again");
        expectedResults.add("Action unsuccessful");

        for (int i = 0; i < 10; i++) {

            Driver.getDriver().findElement(By.linkText("Click here")).click();
            String messageOnClick = Driver.getDriver().findElement(By.id("flash")).getText()
                    .replace('×', ' ').trim();
            System.out.println(messageOnClick);
            Assert.assertTrue(expectedResults.contains(messageOnClick));
        }

        Driver.closeDriver();
    }

}
