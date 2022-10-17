package Assignment;

import Pages.DynamicControlPage;
import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Element;

public class DynamicControls extends TestBase {



    @Test
    public void dynamicControlsRemoveAddTest() throws InterruptedException {

            driver.get(baseUrl + "/dynamic_controls");


           getWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Remove']"))));
           driver.findElement(By.xpath("//button[.='Remove']")).click();
           Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkbox-example']//p[@id='message']")).getText().equalsIgnoreCase("It's gone!"),"Removing check button FAILED!");

           getWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Add']"))));
           driver.findElement(By.xpath("//button[.='Add']")).click();
           Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkbox-example']//p[@id='message']")).getText().equalsIgnoreCase("It's back!"),"Adding check button FAILED");
    }

    @Test
    public void dynamicControlsEnableDisableTest(){
        driver.get(baseUrl + "/dynamic_controls");

        getWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Enable']"))));
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).getText().equalsIgnoreCase("It's enabled!"),"Enabling text area FAILED!");

        getWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Disable']"))));
        driver.findElement(By.xpath("//button[.='Disable']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).getText().equalsIgnoreCase("It's disabled!"),"Disabling text are FAILED!");


    }
}
