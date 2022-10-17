package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlerts extends TestBase {

    @Test
    public void javaScriptAlertTest(){

        driver.get(baseUrl + "/javascript_alerts");

        WebElement JSAlert = driver.findElement(By.xpath("//ul[@style='list-style-type: none;']//button[@onclick='jsAlert()']"));

        JSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String actualConfirmMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedConfirmMessage = "You successfuly clicked an alert";

        Assert.assertEquals(actualConfirmMessage,expectedConfirmMessage,"Accepting JS Alert Test FAILED!");


    }
    @Test
    public void javaScriptAlertConfirmTest(){

        driver.get(baseUrl + "/javascript_alerts");

        WebElement JSConfirm = driver.findElement(By.xpath("//ul[@style='list-style-type: none;']//button[@onclick='jsConfirm()']"));
        JSConfirm.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String actualConfirmMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedConfirmMessage = "You clicked: Ok";

        Assert.assertEquals(actualConfirmMessage,expectedConfirmMessage,"Accepting JS Alert Test FAILED!");
    }

    @Test
    public void javaScriptAlertDismissTest(){
        driver.get(baseUrl + "/javascript_alerts");

        WebElement JSConfirm = driver.findElement(By.xpath("//ul[@style='list-style-type: none;']//button[@onclick='jsConfirm()']"));
        JSConfirm.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String actualConfirmMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedConfirmMessage = "You clicked: Cancel";

        Assert.assertEquals(actualConfirmMessage,expectedConfirmMessage,"Dismissing JS Alert Test FAILED!");
    }


    @Test
    public void javaScriptAlertPromptTestWithSendingText(){

        driver.get(baseUrl + "/javascript_alerts");


        WebElement JSPrompt = driver.findElement(By.xpath("//ul[@style='list-style-type: none;']//button[@onclick='jsPrompt()']"));
        JSPrompt.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Accepting Alert");
        alert.accept();

        String actualConfirmMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedMessage = "You entered: Accepting Alert";

        Assert.assertEquals(actualConfirmMessage,expectedMessage,"Sending Content JS Alert Test FAILED!");

    }
    @Test
    public void javaScriptAlertPromptDismiss(){
        driver.get(baseUrl + "/javascript_alerts");

        WebElement JSPrompt = driver.findElement(By.xpath("//ul[@style='list-style-type: none;']//button[@onclick='jsPrompt()']"));
        JSPrompt.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String actualConfirmMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedMessage = "You entered: null";

        Assert.assertEquals(actualConfirmMessage,expectedMessage,"Dismiss Sending Content JS Alert Test FAILED!");

    }
}
