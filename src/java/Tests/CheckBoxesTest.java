package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

public class CheckBoxesTest extends DriverUtilities {
    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/checkboxes");
    }
    @Test
    public void checkboxes() throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'Checkboxes')]"));
        Assert.assertTrue("User is not on checkboxes page", pageTitle.isDisplayed());

        WebElement checkbox1 = driver.findElement(By.cssSelector("input:nth-of-type(1)"));
        checkbox1.click();
        Assert.assertTrue("Checkbox1 is not selected", checkbox1.isSelected());
        Thread.sleep(2000);

        WebElement checkbox2 = driver.findElement(By.cssSelector("input:nth-of-type(2)"));
        checkbox2.click();
        Assert.assertTrue("Checkbox2 is deselected", !checkbox2.isSelected());
        Thread.sleep(2000);

    }
    @After
    public void cleanUp() {
        quitDriver();
    }
}
