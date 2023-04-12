package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.DriverUtilities;


public class ContextMenuTest extends DriverUtilities {

    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/context_menu");
    }
    @Test
    public void contextMenu(){
        WebDriver driver = getDriver();
        Actions action = new Actions(driver);

        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'Context Menu')]"));
        Assert.assertTrue("User is not on Context Menu page", pageTitle.isDisplayed());

        WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        action.contextClick(box).build().perform();

        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage.trim(), "You selected a context menu");
        driver.switchTo().alert().accept();

    }
    @After
    public void cleanUp() {
        quitDriver();
    }
}
