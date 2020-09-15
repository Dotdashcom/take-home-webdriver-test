package testsDotDash;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class ContextMenu {

    @BeforeMethod
    public void setUpMethod() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "/context_menu");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Test
    public void contextMenuTest() {

        Actions actions = new Actions(Driver.get());

        WebElement source = Driver.get().findElement(By.id("hot-spot"));
        actions.moveToElement(source).contextClick().build().perform();

        Alert alert = Driver.get().switchTo().alert();

        String actualAlertTest = alert.getText();
        System.out.println("actualAlertTest = " + actualAlertTest);
        String expectedAlertText = "You selected a context menu";
        System.out.println("expectedAlertText = " + expectedAlertText);

        Assert.assertTrue(actualAlertTest.contains(expectedAlertText), "You selected a context menu");


    }
}
