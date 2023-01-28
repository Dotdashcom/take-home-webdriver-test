package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicControlsTest {

    private WebDriverWait wait;

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        wait = new WebDriverWait(Driver.getDriver(), 10);
        Driver.getDriver().navigate().to("http://localhost:7080/dynamic_controls");
    }

    @Test
    public void dynamicControls() {
        Driver.getDriver().findElement(By.cssSelector("#checkbox-example > button")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/p")).getText(), "It's gone!");

        Driver.getDriver().findElement(By.cssSelector("#checkbox-example > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/form[1]/p")));
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/p")).getText(), "It's back!");

        Driver.getDriver().findElement(By.cssSelector("#input-example > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")));
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")).getText(), "It's enabled!");

        Driver.getDriver().findElement(By.cssSelector("#input-example > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")));
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")).getText(), "It's disabled!");
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
