package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

public class jsAlertTests extends TestBase{
    String url="javascript_alerts";
    @BeforeTest
    public void setUrl(){
        Driver.setUp(url);
    }



    @Test
    public void AlertAlert() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert=Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.dismiss();
        Thread.sleep(5000);
    }

    @Test
    public void confirmAlert() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert=Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        Thread.sleep(5000);
    }

    @Test
    public void promptAlert() throws InterruptedException {
        String text="js alert managed";
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains(text));
        Thread.sleep(500);
    }


}
