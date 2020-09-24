package MarionelaTirsina;

import MarionelaTirsina.pages.DynamicContent;
import MarionelaTirsina.pages.DynamicControls;
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

public class DynamicControlsTest {
     /*
   Dynamic Controls: http://localhost:7080/dynamic_controls
   Test Dynamic Controls using Explicit Waits.
     */
     DynamicControls dynamicControls=new DynamicControls();

    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/dynamic_controls");
        Driver.getDriver().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

    }


    @Test
    public void dynamicControlsRemove() {
        WebElement removeAddButton = dynamicControls.removeAddButton;
        removeAddButton.click();

        WebElement textBoxActual =dynamicControls.textBox;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(textBoxActual));

        String expectedText = "It's gone!";
        String actualText = textBoxActual.getText();


        Assert.assertTrue("Verfification Passed!",actualText.contains(expectedText));
    }


    @Test
    public void dynamicControlsEnableAndDisable() {

        WebElement enableOrDisable =dynamicControls.enableDisable;
        enableOrDisable.click();

        WebElement inputBox = dynamicControls.inputBox;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("Today it's a good day!");

        String expectedText = "It's enabled!";
        String actualTextBox = dynamicControls.getInputBox.getText();

        Assert.assertTrue(actualTextBox.contains(expectedText));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

    }


}

