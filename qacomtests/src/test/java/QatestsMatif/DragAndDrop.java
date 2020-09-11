package QatestsMatif;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtil.Driver;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(browserUtil.ConfigReader.get("baseUrl") + "/drag_and_drop");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDropTest() {

        Actions actions = new Actions(Driver.get());

        WebElement sc = Driver.get().findElement(By.id("column-a"));
        WebElement target= Driver.get().findElement(By.id("column-b"));

        actions.dragAndDrop(sc,target).perform();

    }
}
