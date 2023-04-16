package com.dotdash_bozcan.assesmentBusra;
import com.dotdash_bozcan.utilities.ConfigurationReader;
import com.dotdash_bozcan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class IframeTest {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/iframe");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

    }
    //Iframe:Test iframe.

    @Test
    public void iframe(){
        Driver.get().switchTo().defaultContent();
        WebElement iframeElement = Driver.get().findElement(By.id("mce_0_ifr"));
        Driver.get().switchTo().frame(iframeElement);

        WebElement textBox = Driver.get().findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();

        textBox.sendKeys("Hello!Busra is in the iframe!");
    }

}
