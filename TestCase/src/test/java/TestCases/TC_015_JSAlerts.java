package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_015_JSAlerts extends  BaseClass
{
    @Test (priority=15) // Test case for JS alerts
    public void JSAlerts() throws InterruptedException
    {
        //Launching JSAlerts URL
        driver.get(BaseUrl+"javascript_alerts");
        //Inspecting First JavaScript Alert Button
        WebElement JSAlert=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        //Click ON JSALert Button
        JSAlert.click();
        //Switching driver to Alert window and clicking on OK button
        driver.switchTo().alert().accept();
        //reading Message after accepting Alert Button
        WebElement JSAText=driver.findElement(By.id("result"));
        System.out.println(JSAText.getText());
        //Assertion Check for JSAlert
        if(driver.getPageSource().contains("successfuly"))
        {
            Assert.assertTrue(true);
            System.out.println("JavaScript Alert Message after click on OK button");
        }
        else
        {
            Assert.assertTrue(false);
        }
        //Inspecting JSConfirm Box
        WebElement JSConfirmBox=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
               JSConfirmBox .click();
        //Switching driver to JSConfirm Box and clicking on Cancel button
        driver.switchTo().alert().dismiss();
        //Getting Text after click on JSConfirm cancel Button
        WebElement JSConfirmText=driver.findElement(By.id("result"));
       System.out.println(JSConfirmBox.getText());
       if(driver.getPageSource().contains("Cancel"))
       {
           Assert.assertTrue(true);
           System.out.println("JavaScript Confirm Message Test Passed");
       }
       else
       {
           Assert.assertTrue(false);
       }

       //Inspecting JSPrompt Button
        WebElement JSPrmptBtn=driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
       JSPrmptBtn.click();
       Thread.sleep(3000);
       //Sending Message to JSprompt Box
       driver.switchTo().alert().sendKeys("Hello");
       //Accepting Alert Box after send message
       driver.switchTo().alert().accept();
       //Inspecting the element to capture sent message
       WebElement JSPrmptText=driver.findElement(By.id("result"));
        //Capturing the Entered message
        System.out.println("Entered Message In JSPrompt Box: "+JSPrmptText.getText());
        //Checking Assertion for JSPrompt Box
        if(driver.getPageSource().contains(" Hello"))
        {
            Assert.assertTrue(true);
        }
        else
            {
            Assert.assertTrue(false);
        }




    }
}
