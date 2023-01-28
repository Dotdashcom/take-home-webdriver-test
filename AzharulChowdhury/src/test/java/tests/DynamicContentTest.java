package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicContentTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/dynamic_content");
    }

    @Test
    public void dynamicContent() {
        String firstRow = Driver.getDriver().findElements(By.cssSelector("#content > .row div[class*='large-10']")).get(0).getText();
        Driver.getDriver().navigate().refresh();
        String refreshedFirstRow = Driver.getDriver().findElements(By.cssSelector("#content > .row div[class*='large-10']")).get(0).getText();
        Assert.assertNotEquals(firstRow, refreshedFirstRow);
    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
