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
        //Printing Error Message
        System.out.println(page_text.getText());
        //Checking Assertion for Error Message
        if(driver.getPageSource().contains("propertyThatDoesNotExist.xyz"))
        {
            Assert.assertTrue(true);
            System.out.println("Page Contains Error: Cannot read property 'xyz' of undefined");
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
}