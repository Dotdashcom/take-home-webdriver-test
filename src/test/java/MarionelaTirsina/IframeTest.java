package MarionelaTirsina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    @Before
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/iframe");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }
    //Iframe: http://localhost:7080/iframe Test iframe.

    @Test
    public void iframe(){
        Driver.get().switchTo().defaultContent(); //I use just to make sure I am not in the iframe
        WebElement iframeElement = Driver.get().findElement(By.id("mce_0_ifr"));
        Driver.get().switchTo().frame(iframeElement);

        WebElement textBox = Driver.get().findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear(); //to clear the existing text in the iframe

        textBox.sendKeys("Hello! Metin is in the iframe!");
    }

}
