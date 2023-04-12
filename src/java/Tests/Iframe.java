package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

public class Iframe extends DriverUtilities {

    @Before
    public void setUp() {
        createDriver();
        getDriver().navigate().to("http://localhost:7080/iframe");
    }

    @Test
    public void iFrame() throws InterruptedException {
        WebDriver driver = getDriver();
        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'iFrame containing')]"));
        Assert.assertTrue("User is not on iFrame page", pageTitle.isDisplayed());

        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);

        WebElement frame1 = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
        Thread.sleep(1000);
        frame1.clear();

        frame1.sendKeys("Hello");
        Thread.sleep(2000);

        String act = frame1.getText();
        String exp = "Hello";
        Assert.assertEquals("Text is not the same",act, exp);
    }



    @After
    public void cleanUp() {
        quitDriver();
    }
}
