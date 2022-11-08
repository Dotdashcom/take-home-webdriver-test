package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {

    WebDriver driver;

    //Initializing the page Objects
    public IFramePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void Frame(){
        driver.get("http://localhost:7080/iframe");
        driver.findElement(By.className("tox-mbtn__select-label")).click();
        driver.findElement(By.className("tox-collection__item-label")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div/div[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/div[1]/div[1]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[1]/div[1]/h1")).click();
    }


}
