package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_016_JavaScriptError extends BaseClass
{
    @Test (priority=16) // Test case for JS Error
    public void JavaScriptError()
    {
        //Launching JavaScript Error Url
        driver.get(BaseUrl + "javascript_error");
        //Inspecting Java Script Error Message
        WebElement page_text = driver.findElement(By.xpath("/html/body/p"));

        //Approach1: Asserts if page contains error
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("JavaScript error"));

        //Approach2: Using PageSource to check for "propertyThatDoesNotExist.xyz"
        Assert.assertTrue(driver.getPageSource().contains("propertyThatDoesNotExist.xyz"));
    }
}