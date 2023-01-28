package tests;

import Utility.Driver;
import Utility.StringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

public class NotificationTest {

    @BeforeTest
    public void setup(){
    Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/notification_message_rendered");
}

    @Test
    public void notification() {
        String arr[] = { "Action successful", "Action unsuccesful, please try again" };
        for (int i = 0; i < 4; i++) {
            Driver.getDriver().findElement(By.cssSelector("#content a")).click();
            String status = Driver.getDriver().findElement(By.cssSelector("#flash")).getText();
            Boolean cond = Arrays.asList(arr).contains(StringUtils.removeWhiteSpace(status).replace("×", ""));
            Assert.assertTrue(cond);
        }
    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
