package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IframeTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/iframe");
    }

    @Test
    public void iframe() {
        Driver.getDriver().switchTo().frame("mce_0_ifr");
        WebElement el = Driver.getDriver().findElement(By.cssSelector("#tinymce"));
        el.clear();
        el.sendKeys("test");
        Assert.assertEquals(el.getText(), "test");
    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }

}
