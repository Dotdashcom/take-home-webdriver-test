package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_008_DynamicControls extends BaseClass
{
    @Test (priority=8) // Testcase for Dynamic Controls
    public void Dynamic_Controls() throws InterruptedException
    {
        //Launching Dynamic Controls URL
        driver.get(BaseUrl + "dynamic_controls");
        //Inspecting  WebElement CheckBox for Clicking
        driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input ")).click();
        //Using WebDriver Wait for Explicit Wait
        WebDriverWait mywait = new WebDriverWait(driver, 10);
        //Inspecting WebElement Remove Button to click on it
        WebElement RemvBtn = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        RemvBtn.click();
        Thread.sleep(3000);
        //Inspecting text after click on Remove Button
        WebElement TxtForChkBoxRemv=driver.findElement(By.xpath("//*[@id=\"message\"]"));
        System.out.println("Text for Check Box after click on Remove Button :"+TxtForChkBoxRemv.getText());
        //Assertion Checking for check box is Gone!
        if(driver.getPageSource().contains("It's gone!"))
        {

            Assert.assertTrue(true);
            System.out.println("Assertion test passed for CheckBox Gone");

        }
        else
        {
            Assert.assertTrue(false);
        }

        //Inspecting AddBtn and Using Explicit wait condition on AddBtn
        WebElement AddBtn = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
        AddBtn.click();
        Thread.sleep(3000);
        //Inspecting text after click on Add Button
        WebElement TxtForAddBtn= driver.findElement(By.xpath("//*[@id='message']"));
        System.out.println("Text for Check Box After click on Add  Button: "+TxtForAddBtn.getText());
        //Assertion checking for CheckBox is Back!
        if(driver.getPageSource().contains("It's back!"))
        {

            Assert.assertTrue(true);
            System.out.println("Assertion test passed for CheckBox present");

        }
        else
        {
            Assert.assertTrue(false);
        }

        //Inspecting Enable Button to click Using Explicit Wait condition
        WebElement EnblBtn = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/button")));
        EnblBtn.click();
        Thread.sleep(3000);
        WebElement TxtForEnablBtn=driver.findElement(By.xpath("//*[@id='message']"));
        System.out.println("Text after clicking on Enable Button: "+TxtForEnablBtn.getText());


        //Assertion checking for Enable Button
        if(driver.getPageSource().contains("It's enabled!"))
        {

            Assert.assertTrue(true);
            System.out.println("Assertion check passes for Enable Button");
        }
        else
        {
            Assert.assertTrue(false);
        }
        //inspecting WebElement TextBOx to send Message
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).sendKeys("Hello");
        // Thread.sleep(3000);
        //Inspecting Disable Button to click by applying  Explicit Wait condition
        WebElement DisblBtn = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/button")));
        DisblBtn.click();
        Thread.sleep(3000);
        WebElement TxtforDsblBtn=driver.findElement(By.xpath("//*[@id=\"message\"]"));
        System.out.println("Text after clicking on Disable Button: "+TxtforDsblBtn.getText());
        //Assertion checking for Disable Button
        if(driver.getPageSource().contains("It's disabled!"))
        {

            Assert.assertTrue(true);
            System.out.println("Assertion check passes for Disable Button");
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
}
