package MarionelaTirsina;

import MarionelaTirsina.pages.Iframe;
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
    //Iframe: http://localhost:7080/iframe Test iframe.
    Iframe iframe= new Iframe();

    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/iframe");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }




    @Test
    public void iframe(){
        Driver.getDriver().switchTo().defaultContent();
        WebElement iframeElement = iframe.iframe;
        Driver.getDriver().switchTo().frame(iframeElement);

      WebElement textBox= iframe.textBox;
       // textBox.getText(Sen)

        textBox.sendKeys("Hello! Metin is in the iframe!");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

    }

}
