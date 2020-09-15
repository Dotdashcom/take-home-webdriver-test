package testsDotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

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
        Driver.closeDriver();
    }


    @Test
    public void iframe(){
        Driver.get().switchTo().defaultContent();
        WebElement iframeElement = Driver.get().findElement(By.id("mce_0_ifr"));
        Driver.get().switchTo().frame(iframeElement);

        WebElement textBox = Driver.get().findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();

        textBox.sendKeys("Hello! Metin is in the iframe!");
    }

}
