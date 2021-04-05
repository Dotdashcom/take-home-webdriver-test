package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_013_Iframe extends BaseClass
{
    @Test (priority=13) // Test case for frame selection
    public void IFrame() throws InterruptedException
    {
        //Launching IFrame URL
        driver.get(BaseUrl+"iframe");
        Thread.sleep(3000);
        //Closing Alert Message displaying on Scrren
        driver.findElement(By.xpath("/html/body/div[4]/div/div/button")).click();
        //Finding Frame WebElement
        WebElement iFrame=driver.findElement(By.id("mce_0_ifr"));
        //Switching driver to IFrame
        driver.switchTo().frame(iFrame);
        //Clears text displaying in Iframe
        driver.findElement(By.xpath("//*[@id='tinymce']/p")).clear();
        //Inspecting Frame Element to send Text message in Iframe
        driver.findElement(By.xpath("//*[@id='tinymce']/p")).sendKeys("Hello");
        WebElement SentText=driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        Thread.sleep(3000);
        //Printing Send Message
        System.out.println(SentText.getText());

        //Inspecting Sent Text Message for Assertion check
        WebElement ExpText=driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        System.out.println("Sent Message in Frame: "+ExpText.getText());
        //Assertion checking for text as expected or not
        if(SentText.equals(ExpText))
        {
            Assert.assertTrue(true);
            System.out.println("Typed text as Expected");

        }
        else
        {
            Assert.assertTrue(false);
        }


    }
}
