package shakilTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest_15 extends TestBase {

    @Test
    public void testJavaScriptAlerts() {
        driver.get("http://localhost:7080/javascript_alerts");

        // Test JS Alert
        WebElement jsAlertButton = driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']"));
        jsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage1 = alert.getText();
        Assert.assertEquals(alertMessage1, "I am a JS Alert");
        alert.accept();

        // Test JS Confirm
        WebElement jsConfirmButton = driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']"));
        jsConfirmButton.click();
        alert = driver.switchTo().alert();
        String alertMessage2 = alert.getText();
        Assert.assertEquals(alertMessage2, "I am a JS Confirm");
        alert.dismiss();

        // Test JS Prompt
        WebElement jsPromptButton = driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']"));
        jsPromptButton.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Hello World!");
        alert.accept();
        String resultText = driver.findElement(By.xpath("/html//p[@id='result']")).getText();
        Assert.assertEquals(resultText, "You entered: Hello World!");
    }
}



/*

 
Click for JS Alert   xpath //div[@id='content']//ul//button[.='Click for JS Alert']  alert message: I am a JS Alert
Click for JS Confirm  //div[@id='content']//ul//button[.='Click for JS Confirm'] alert message:  I am a JS Confirm
Click for JS Prompt //div[@id='content']//ul//button[.='Click for JS Prompt'] type message: Hello World!

You entered: Hello World! /html//p[@id='result'] 









*/