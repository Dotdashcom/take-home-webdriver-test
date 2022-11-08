package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicPage {

    WebDriver driver;

    //Initializing the page Objects
    public DynamicPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void dynamiControl() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_controls");
        //REMOVE BUTTON
        clickOn(driver, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button")),10 ); //Checkbox
        Thread.sleep(5000);
        String text =  driver.findElement(By.id("message")).getText();
        Assert.assertEquals(text,"It's gone!");

        //ADD BUTTON
        clickOn(driver, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button")),10 ); //Checkbox
        Thread.sleep(5000);
        String text2 =  driver.findElement(By.id("message")).getText();
        Assert.assertEquals(text2,"It's back!");        //FIRST VERIFICATION
        Thread.sleep(5000);
        String text3 =  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/div[1]")).getText();
        Assert.assertEquals(text3,"A checkbox"); //SECOND VERIFICATION


        //CLICK ENABLE BUTTON
        clickOn(driver, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button")),10 ); //Checkbox
        Thread.sleep(5000);
        String text4 =  driver.findElement(By.id("message")).getText();
        Assert.assertEquals(text4,"It's enabled!");        //FIRST VERIFICATION

        //CLICK DISABLE BUTTON
        clickOn(driver, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button")),10 ); //Checkbox
        Thread.sleep(5000);
        String text5 =  driver.findElement(By.id("message")).getText();
        Assert.assertEquals(text5,"It's disabled!");        //FIRST VERIFICATION
    }



    public void dynamicLoading() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_loading/2");

        //START BUTTON
        clickOn(driver, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button")),10 ); //Checkbox
        Thread.sleep(5000);
        String text =  driver.findElement(By.id("finish")).getText();
        System.out.println(text);
        Assert.assertEquals(text,"Hello World!");

    }


    //Explicit wait, wait to specific element (LOCATOR) for click on that and later continue with next step
    public static void clickOn(WebDriver driver, WebElement locator, int timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }


}
