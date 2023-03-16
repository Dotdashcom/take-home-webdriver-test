package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Iframe {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void Iframe() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        Driver.getDriver().get("http://localhost:7080/iframe");
        Driver.getDriver().findElement(By.xpath("//div[@class='tox-icon']")).click();
        Driver.getDriver().switchTo().frame("mce_0_ifr");
        WebElement text = Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']"));
        text.clear();
        text.sendKeys("Iframe tested");
        assertTrue(text.isDisplayed());
        assertTrue(text.getText().equals("Iframe tested"));
        Driver.getDriver().switchTo().parentFrame();
        WebElement header = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(header.isDisplayed(), "Header is did not appear");
        Assert.assertEquals(header.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
    }
}
