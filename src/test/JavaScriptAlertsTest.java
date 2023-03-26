package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class JavaScriptAlertsTest extends CommonMethods {
    public static void main(String[]args){
        setUp("http://localhost:7080/javascript_alerts");

        WebElement jsAlertButton = driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']"));
        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[text() = 'Click for JS Confirm']"));
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']"));

        //js alert
        jsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String expectedJsAlertMessage = "You successfuly clicked an alert";
        String actualJsAlertMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualJsAlertMessage, expectedJsAlertMessage);
        System.out.println("Alert message of JS Alert is as expected");


        //confirmation alert
        jsConfirmButton.click();
        driver.switchTo().alert();
        alert.accept();
        String expectedJsConfirmAlertMessage = "You clicked: Ok";
        String actualJsConfirmAlertMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualJsConfirmAlertMessage,  expectedJsConfirmAlertMessage);
        System.out.println("Alert message of JS Confirm Alert is as expected");


        //prompt alert
        jsPromptButton.click();
        driver.switchTo().alert();
        alert.sendKeys("Hello World!");
        alert.accept();
        String expectedPromptAlertMessage = "You entered: Hello World!";
        String actualPromptAlertMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualPromptAlertMessage,expectedPromptAlertMessage);
        System.out.println("The prompt alert message contains the typed message");

   tearDown();
    }
}
