package QatestsMatif;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtil.Driver;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(browserUtil.ConfigReader.get("baseUrl") + "/iframe");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void iframe(){
        Driver.get().switchTo().defaultContent(); //I use just to make sure I am not in the iframe
        WebElement iframeElement = Driver.get().findElement(By.id("mce_0_ifr"));
        Driver.get().switchTo().frame(iframeElement);

        WebElement textBox = Driver.get().findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();

        textBox.sendKeys("I like sunshine :)");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
    }
}
