package MarionelaTirsina;

import MarionelaTirsina.pages.DynamicLoading;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingTest {
    /**
     * Dynamic Loading: http://localhost:7080/dynamic_loading/2
     *     Test Dynamic Loading using Explicit Waits.
     */

    DynamicLoading dynamicLoadingTest=new DynamicLoading();
    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/dynamic_loading/2");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void dynamicLoadingTest() {
        WebElement startB= dynamicLoadingTest.startButton;
        startB.click();

        WebElement textHelloWorld = dynamicLoadingTest.helloWorld;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(textHelloWorld));

        String expectedText = "Hello World!";
        String actualText = textHelloWorld.getText();

        Assert.assertEquals(actualText,(expectedText));
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);

    }
}



