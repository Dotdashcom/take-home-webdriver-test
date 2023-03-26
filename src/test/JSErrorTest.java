package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class JSErrorTest extends CommonMethods {
    public static void main(String[]args){
        setUp("http://localhost:7080/javascript_error");

        WebElement jSError = driver.findElement(By.xpath("//p[contains(text(), 'JavaScript error')]"));
        Assert.assertTrue(jSError.isDisplayed());
        System.out.println("The test is passed. JS error message is displayed");

        tearDown();
    }
    }

