package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

public class DragAndDrop extends DriverUtilities {

    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/drag_and_drop");
    }
    @Test
    public void DragAndDrop() {
        WebDriver driver = getDriver();

        WebElement elementA = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement elementB = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));

       JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String dragAndDropScript =
                "var source = arguments[0];" +
                        "var target = arguments[1];" +
                        "const dataTransfer = new DataTransfer();" +
                        "const dragstartEvent = new DragEvent('dragstart', { dataTransfer });" +
                        "source.dispatchEvent(dragstartEvent);" +
                        "target.dispatchEvent(new DragEvent('dragenter', { dataTransfer }));" +
                        "target.dispatchEvent(new DragEvent('dragover', { dataTransfer }));" +
                        "target.dispatchEvent(new DragEvent('drop', { dataTransfer }));" +
                        "source.dispatchEvent(new DragEvent('dragend', { dataTransfer }));";

        jsExecutor.executeScript(dragAndDropScript, elementB, elementA);

        Assert.assertEquals(elementA.getText(), "B");
        Assert.assertEquals(elementB.getText(), "A");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}
