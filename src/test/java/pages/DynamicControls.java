package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControls extends POBase {
    public void verifyDynamicControls(){
        getElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(BrowserUtil.GetDriver(),20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@label='blah']")));
        Assert.assertFalse(isElementPresent(By.xpath("//input[@label='blah']")));
        getElement(By.xpath("//button[text()='Add']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        Assert.assertTrue(getElement(By.id("checkbox")).isDisplayed());
        getElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@disabled]")));
        Assert.assertTrue(getElement(By.xpath("//input[@type='text']")).isEnabled());
        getElement(By.xpath("//button[text()='Disable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@disabled]")));
        Assert.assertFalse(getElement(By.xpath("//input[@type='text']")).isEnabled());
    }
}
