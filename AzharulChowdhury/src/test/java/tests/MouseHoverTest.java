package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHoverTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/hovers");
    }

    @Test
    public void mouseHover() {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(Driver.getDriver().findElement(By.cssSelector("#content > div > div:nth-child(3) > img"))).build().perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5")).isDisplayed());

        action.moveToElement(Driver.getDriver().findElement(By.cssSelector("#content > div > div:nth-child(4) > img"))).build().perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.cssSelector("#content > div > div:nth-child(4) > div > h5")).isDisplayed());

        action.moveToElement(Driver.getDriver().findElement(By.cssSelector("#content > div > div:nth-child(5) > img"))).build().perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.cssSelector("#content > div > div:nth-child(5) > div > h5")).isDisplayed());
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
