package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

public class DynamicContent extends DriverUtilities {
    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/dynamic_content");
    }
    @Test
    public void dynamicContent(){
        WebDriver driver = getDriver();

        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'Dynamic Content')]"));
        Assert.assertTrue("User is not on Dynamic Context page", pageTitle.isDisplayed());

        for (int i = 0; i < 3; i++) {
            String a = driver.getPageSource();
            driver.navigate().refresh();
            Assert.assertNotEquals(a, driver.getPageSource());
        }

    }
    @After
    public void cleanUp() {
        quitDriver();
    }
}
