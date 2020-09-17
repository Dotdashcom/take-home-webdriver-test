package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;
import utils.Driver;
import utils.TestBase;

public class DynamicContentTests extends TestBase {

    String url="dynamic_content";

    @Test
    public void contentChange(){
        Driver.setUp(url);
        int i=5;
        do {
            String content = Driver.getDriver().findElement(By.cssSelector("#content")).getText();
            Driver.getDriver().navigate().refresh();
            String content2 = Driver.getDriver().findElement(By.cssSelector("#content")).getText();
            Assert.assertNotEquals(content, content2);
            i--;
        }while (i>=0);
    }
}
