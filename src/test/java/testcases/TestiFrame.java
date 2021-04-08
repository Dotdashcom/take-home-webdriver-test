package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.iFramePage;
import utils.ConfigReader;
import utils.Driver;

public class TestiFrame {
    iFramePage iFramePage = new iFramePage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "frames";
        Driver.getDriver().get(url);
    }

    @Test
    public void testiFrame() {
        iFramePage.iframeBtn.click();
        WebElement contentBody = Driver.getDriver().switchTo().frame("mce_0_ifr").findElement(By.id("tinymce"));
        contentBody.clear();
        String message = "Have a nice day!";
        contentBody.sendKeys(message);
        Assert.assertEquals(message, iFramePage.contentBody.getText());
    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
