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

public class MouseHover extends DriverUtilities{
    @Before
    public void setUp() {
        createDriver();
        getDriver().navigate().to("http://localhost:7080/hovers");
    }

    @Test
    public void hovers(){
        WebDriver driver = getDriver();
        Actions action = new Actions(driver);

        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'Hovers')]"));
        Assert.assertTrue("User is not on Hovers page", pageTitle.isDisplayed());

        WebElement image1 = driver.findElement(By.xpath("/html//div[@id='content']/div/div[1]/img[@alt='User Avatar']"));
        WebElement image2 = driver.findElement(By.xpath("/html//div[@id='content']/div/div[2]/img[@alt='User Avatar']"));
        WebElement image3 = driver.findElement(By.xpath("/html//div[@id='content']/div/div[3]/img[@alt='User Avatar']"));

        action.moveToElement(image1).perform();
        WebElement additionalInfo1 = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        Assert.assertTrue("Additional info is not displayed for image1",additionalInfo1.isDisplayed());

        action.moveToElement(image2).perform();
        WebElement additionalInfo2 = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
        Assert.assertTrue("Additional info is not displayed for image2",additionalInfo2.isDisplayed());

        action.moveToElement(image3).perform();
        WebElement additionalInfo3 = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));
        Assert.assertTrue("Additional info is not displayed for image3",additionalInfo3.isDisplayed());
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}
