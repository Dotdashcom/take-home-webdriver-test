package MarionelaTirsina;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class ContextMenu {

    @Before
    public void setUpMethod() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "/context_menu");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    /*
    ContextMenu: http://localhost:7080/context_menu
    Right-click in the box to see one called 'the-internet'.
    Test JavaScript alert text on Right-Click.
     */
    @Test
    public void contextMenuTest() {

        Actions actions = new Actions(Driver.get());

        WebElement source = Driver.get().findElement(By.id("hot-spot"));
        actions.moveToElement(source).contextClick().build().perform();

        //Switch to Alert and get the text message
        Alert alert = Driver.get().switchTo().alert();

        String actualAlertTest = alert.getText();
        System.out.println("actualAlertTest = " + actualAlertTest);
        String expectedAlertText = "You selected a context menu";
        System.out.println("expectedAlertText = " + expectedAlertText);

        Assert.assertTrue("You selected a context menu",actualAlertTest.contains(expectedAlertText) );

    }


}
