package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicLoading extends Base {
    WebDriver driver;
    @Test
    public void dynamicLoading(){
        driver = getDriver();
        driver.get("http://localhost:7080/dynamic_loading/2");

        /*
        * To avoid syncronization problem and to avoid noSuchElementExecption I am
        * using explicit wait so that it will not throw this exception until the element
        * is loaded.
        *
        * */
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Start')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();


        WebElement text = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));


        String actual = (text.getText());
        String expected = "Hello World!";

        // Just validating if the actual and expected are equal
        Assert.assertEquals(actual, expected);




    }

}
