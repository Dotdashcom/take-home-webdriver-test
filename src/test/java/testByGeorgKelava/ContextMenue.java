package testByGeorgKelava;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class ContextMenue {

        public ContextMenue() {
        }

        @BeforeMethod
        public void setUp() {
            Driver.get().get(ConfigurationReader.get("baseUrl") + "context_menu");
            Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        }


        @Test
        public void contextMenuTest() {
            Actions actions = new Actions(Driver.get());
            WebElement source = Driver.get().findElement(By.id("hot-spot"));
            actions.moveToElement(source).contextClick().build().perform();
            Alert alert = Driver.get().switchTo().alert();
            String actualAlertTxt = alert.getText();
            System.out.println("actualAlertTxt = " + actualAlertTxt);
            String expectedAlertTxt = "You selected a context menu";
            System.out.println("expectedAlertTxt = " + expectedAlertTxt);
            Assert.assertTrue(actualAlertTxt.contains(expectedAlertTxt), "You selected a context menu");
        }
}
