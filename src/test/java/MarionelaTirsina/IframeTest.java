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
            WebElement iframeElement =iframe.iframe;
            Driver.getDriver().switchTo().frame(iframeElement);

            WebElement textBox = Driver.getDriver().findElement(By.xpath("//p[text()='Your content goes here.']"));
            textBox.clear();
            textBox.sendKeys("Today it's a beautiful day!");
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

    }

}
