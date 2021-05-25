package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoading extends POBase {
    public void verifyDynamicLoading(){
        getElement(By.xpath("//button[text()='Start']")).click();
        WebDriverWait wait = new WebDriverWait(BrowserUtil.GetDriver(),20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        Assert.assertTrue(getElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
    }
}
