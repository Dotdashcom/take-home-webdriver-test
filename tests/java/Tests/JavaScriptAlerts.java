package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptAlerts {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void JavaScriptAlerts() {
        Driver.getDriver().get("http://localhost:7080/javascript_alerts");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        WebElement confirmAlertBtn = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertBtn.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        WebElement resultText = Driver.getDriver().findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed(), "result text did not appear!");
        Assert.assertEquals(resultText.getText(), "You clicked: Ok");
    }
}
