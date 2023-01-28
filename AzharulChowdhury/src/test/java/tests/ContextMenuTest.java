package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenuTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/context_menu");
    }

    @Test
    public void contextMenu() {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(Driver.getDriver().findElement(By.id("hot-spot"))).perform();
        String alertText = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertText, "You selected a context menu");
    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }

}
