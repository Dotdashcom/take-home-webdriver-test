package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_014_MouseHover extends  BaseClass
{
    @Test (priority=14) // Test case for Mouse hover
    public void MouseHover() throws InterruptedException
    {
       //Launching MouseHover Url
        driver.get(BaseUrl+"hovers");
        //Inspecting WebElements for MouseHover Action
        WebElement image1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        //Using Actions Class for Mouse Actions
        Actions act=new Actions(driver);
        //using MouseHover on WbElements using Actions class object
        act.moveToElement(image1).build().perform();
        //Inspecting User1 name
        WebElement name1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        System.out.println(name1.getText());
        //Inspecting to click on user1 viewProfile
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
         Thread.sleep(3000);
         //Inspecting User1 Additional information
        WebElement User1Info= driver.findElement(By.xpath("//*[@id=\"c\"]/pre"));
        //Printing User1 additional information
        System.out.println(User1Info.getText());
        //Checking Assertion for User1 information
        if(driver.getPageSource().contains("'/users/1'"))
        {
            Assert.assertTrue(true);
            System.out.println("Image1 Additional information is Displaying");
        }
        else
        {
            Assert.assertTrue(false);
        }
        //navigating driver from user1 url to hovers url
        driver.navigate().back();
         Thread.sleep(3000);
         //Inspecting image2
        WebElement image2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        //Mouse hover on Image2
         act.moveToElement(image2).build().perform();
         //Inspecting User2 name
        WebElement name2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
        //Displaying user2 name
        System.out.println(name2.getText());
        //inspecting element to click on user2 'view Profile'
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        Thread.sleep(3000);
        //Inspecting User2 Additional Information
        WebElement User2Info=driver.findElement(By.xpath("//*[@id=\"c\"]/pre"));
        //Printing User2 Additional Information
        System.out.println(User2Info.getText());
        //Checking Assertion for User2 Information
        if(driver.getPageSource().contains("'/users/2'"))
        {
            Assert.assertTrue(true);
            System.out.println("Image2 Additional Information is Displaying");
        }
        else
        {
            Assert.assertTrue(false);
        }
        //Navigating driver to 'hovers' url from user2 url
        driver.navigate().back();
        //Inspecting image3
        WebElement image3=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        //mouse hover on image3
        act.moveToElement(image3).build().perform();
        //Inspecting name from image3
        WebElement name3=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
        //Printing user3 name
        System.out.println(name3.getText());
        //inspecting element to click on User3 'View profile'
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).click();
        Thread.sleep(3000);
        //Inspecting User3 Additional Information
        WebElement User3Info= driver.findElement(By.xpath("//*[@id=\"c\"]/pre"));
        //Printing User3 Additional Information
        System.out.println(User3Info.getText());
        //Checking Assertion for User3 Additional information
        if(driver.getPageSource().contains("'/users/3'"))
        {
            Assert.assertTrue(true);
            System.out.println("Image3 Additional information is Displaying");
        }
        else
        {
            Assert.assertTrue(false);
        }


        //navigating driver to hovers Url from users/3 url
        driver.navigate().back();
        //Inspecting  3 Images again for mouse Hover to avoid getting Stale Element Exception
        WebElement imageA=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        WebElement imageB=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        WebElement imageC=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        act.moveToElement(imageA).moveToElement(imageB).moveToElement(imageC).click().build().perform();
    }
}
