package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {
    public DragAndDrop() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "drag_and_drop");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @Test
    public void dragAndDropTest() {
        Actions actions = new Actions(Driver.get());
        WebElement source = Driver.get().findElement(By.id("column-a"));
        WebElement target = Driver.get().findElement(By.id("column-b"));
        actions.dragAndDrop(source, target).perform();
    }
}
