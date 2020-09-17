package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

public class IframeTests extends TestBase {
    String url="iframe";
    String text="Hello world";
    @Test
    public void iframe(){
        Driver.setUp(url);
        WebElement iFrame=Driver.getDriver().findElement(By.id("mce_0_ifr"));
        Driver.getDriver().switchTo().frame(iFrame);
        WebElement typingBox=Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']"));
        typingBox.clear();
        typingBox.sendKeys(text);
        Assert.assertEquals(Driver.getDriver().findElement(By.id("tinymce")).getText(),text);


    }
}
