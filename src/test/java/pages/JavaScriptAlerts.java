package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JavaScriptAlerts extends POBase {
    public void verifyJavaScriptAlerts(){
        WebDriver driver = BrowserUtil.GetDriver();
        getElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        String alertMessageExpected = "I am a JS Alert";
        String alertMessageActual = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessageActual, alertMessageExpected);
        driver.switchTo().alert().accept();
        getElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alertMessageExpected = "I am a JS Confirm";
        alertMessageActual = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessageActual, alertMessageExpected);
        driver.switchTo().alert().accept();
        getElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        String message = "Dotdash future employee!";
        driver.switchTo().alert().sendKeys(message);
        driver.switchTo().alert().accept();
        Assert.assertTrue(isElementPresent(By.xpath("//p[text()='You entered: " + message + "']")));
    }
}
