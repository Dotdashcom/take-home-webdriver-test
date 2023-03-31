package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Iframe;

public class IframeTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/iframe");
        Iframe sendText = new Iframe(driver);
        sendText.switchToFrame(driver);
        Assert.assertTrue(sendText.expected(), "Hello");

    }
}
