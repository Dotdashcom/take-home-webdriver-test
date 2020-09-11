package webdrivertest;

import common.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlert extends Base {
    WebDriver driver;
    @Test
    public void javaScriptAlert(){
        driver = getDriver();
        driver.get("http://localhost:7080/javascript_alerts");

        /*
        * In order to user the alert pop up I used Alert interface.
        * So, first I switched to the alert window by switchTo().alert() methods
        * And, then I used following methods
        * accept() - to click on ok button
        * dismiss() - to click on cancel button
        * getText() - to get the text present on the alert
        * sendKeys() - to enter the text on the alert
        * Also I used TestNG assertEqual method to validate if
        * the actual and expected are equals, if not then test will not pass.
        * if it is then test will pass
        * */

        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();

        String expected1 = "I am a JS Alert";
        String actual1 = alert.getText();
        System.out.println(expected1);
        alert.accept();

        Assert.assertEquals(actual1, expected1);

        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();

        String expected2 = "I am a JS Confirm";
        String actual2 = alert.getText();
        System.out.println(expected2);
        alert.dismiss();
        Assert.assertEquals(actual2, expected2);

        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        alert.sendKeys("MiftahChowdhury");

        String expected3 = "I am a JS prompt";
        String actual3 = alert.getText();
        System.out.println(expected3);
        alert.accept();

        Assert.assertEquals(actual3, expected3);

    }
}
