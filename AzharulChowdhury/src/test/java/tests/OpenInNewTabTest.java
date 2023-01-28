package tests;

import Utility.Driver;
import Utility.StringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenInNewTabTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/windows");
    }

    @Test
    public void tab() {
        String curr = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.cssSelector("#content a")).click();
        int length = Driver.getDriver().getWindowHandles().size();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            if (!curr.contentEquals(handle)) {
                Driver.getDriver().switchTo().window(handle);
                break;
            }
        }
        String txt = Driver.getDriver().findElement(By.cssSelector("h3")).getText();
        Assert.assertEquals(StringUtils.removeWhiteSpace(txt), "New Window");
    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
