package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrame extends TestBase {

    @Test
    public void iFrameTest(){


        driver.get(baseUrl + "/iframe");

        WebElement contentIFrame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        driver.switchTo().frame(contentIFrame);

        WebElement contentInput = driver.findElement(By.xpath("//body[@id='tinymce']"));
        contentInput.clear();
        contentInput.sendKeys("Testing IFrame");

        String actualText = driver.findElement(By.xpath("//body[@id='tinymce']/p[1]")).getText();
        String expectedText = "Testing IFrame";

        Assert.assertEquals(actualText,expectedText,"IFrame Test FAILED!");

    }
}
