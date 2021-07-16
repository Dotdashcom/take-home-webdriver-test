package com.dotdash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Test15JavaScriptAlerts extends BaseMethod {
    @Test
    public void testJsAlerts() {
        driver.get("http://localhost:7080/javascript_alerts");
        findByVisibility(By.cssSelector(".example li:nth-child(2) button")).click();
        Alert popup = driver.switchTo().alert();
        popup.accept();
        String actualResultTxt = findByVisibility(By.id("result")).getText();
        Assert.assertEquals("You clicked: Ok", actualResultTxt);
    }

}