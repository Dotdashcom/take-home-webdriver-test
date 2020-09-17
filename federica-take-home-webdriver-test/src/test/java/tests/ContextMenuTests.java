package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;
import utils.Driver;
import utils.TestBase;

import java.util.concurrent.TimeUnit;

public class ContextMenuTests extends TestBase {
    String url="/context_menu";
    Actions actions;
    @Test
    public void jsAlertTest() throws InterruptedException {
        Driver.setUp(url);
        actions=new Actions(Driver.getDriver());
        actions.contextClick(Driver.getDriver().findElement(By.id("hot-spot"))).perform();
        Alert alert=Driver.getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().contains("You selected a context menu"));

    }
}
