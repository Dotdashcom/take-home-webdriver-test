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

public class FloatingMenu extends DriverUtilities {

    @Before
    public void setUp() {
        createDriver();
        getDriver().navigate().to("http://localhost:7080/floating_menu");
    }

    @Test
    public void floatingMenu() {
        WebDriver driver = getDriver();
        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'Floating Menu')]"));
        Assert.assertTrue("User is not on Floating Menu page", pageTitle.isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement menu = driver.findElement(By.xpath("//div[@id=\"menu\"]"));

        Assert.assertTrue(menu.isDisplayed());
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}
