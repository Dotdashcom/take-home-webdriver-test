package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

import java.util.Set;

public class OpenInNewTabTest extends DriverUtilities {
    @Before
    public void setUp() {
        createDriver();
        getDriver().navigate().to("http://localhost:7080/windows");
    }
    @Test
    public void openNewTab(){
        WebDriver driver = getDriver();
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }

        String pageTitle = driver.getTitle();
        Assert.assertEquals("New Window", pageTitle);
    }


    @After
    public void cleanUp() {
        quitDriver();
    }

}
