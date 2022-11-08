package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MouseHoverPage {
    WebDriver driver;


    //Initializing the page Objects
    public MouseHoverPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void mouseHover() {

        driver.get(" http://localhost:7080/hovers ");

        WebElement image =  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(image).perform();
        String message  = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/h5")).getText();
        Assert.assertEquals(message,"name: user1");

        WebElement image2 =  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/img"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(image2).perform();
        String message2  = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/h5")).getText();
        Assert.assertEquals(message2,"name: user2");

        WebElement image3 =  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/img"));
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(image3).perform();
        String message3  = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/h5")).getText();
        Assert.assertEquals(message3,"name: user3");

        WebElement image4 =  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img"));
        Actions actions4 = new Actions(driver);
        actions4.moveToElement(image4).perform();

    }


}
