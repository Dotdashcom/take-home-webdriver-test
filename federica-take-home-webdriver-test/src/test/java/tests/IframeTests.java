package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

import java.util.concurrent.TimeUnit;

public class IframeTests extends TestBase {
    String url="iframe";
    String text="Hello world";
    @Test
    public void iframe(){
        Driver.setUp(url);
        WebElement iFrame=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement typingBox=driver.findElement(By.xpath("//body[@id='tinymce']"));
        typingBox.clear();
        typingBox.sendKeys(text);
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(),text);


    }
}
