package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

public class jsAlertTests extends TestBase{
    String url="javascript_alerts";



    @Test
    public void AlertAlert(){
        Driver.setUp(url);
        Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert=Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.dismiss();
    }

    @Test
    public void confirmAlert(){
        Driver.setUp(url);
        Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert=Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
    }

    @Test
    public void promptAlert() throws InterruptedException {
        String text="js alert managed";
        Driver.setUp(url);
        Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        Assert.assertTrue(Driver.getDriver().findElement(By.id("result")).getText().contains(text));
    }


}
