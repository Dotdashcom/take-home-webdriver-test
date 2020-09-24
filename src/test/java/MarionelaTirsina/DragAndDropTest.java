package MarionelaTirsina;

import MarionelaTirsina.pages.DragAndDrop;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DragAndDropTest {
    /*Drag and Drop: http://localhost:7080/drag_and_drop
    Perform  Drag And Drop in a Webdriver test.*/
    DragAndDrop dragAndDrop=new DragAndDrop();
    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/drag_and_drop");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void dragAndDropTest() {

        Actions actions = new Actions(Driver.getDriver());
        WebElement source = dragAndDrop.columnA;
        WebElement target =dragAndDrop.columnB;
        actions.dragAndDrop(source, target).perform();

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }



}
