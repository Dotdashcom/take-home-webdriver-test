package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramePage extends BasePage{

    protected WebDriver driver;
    By iFramePage = By.cssSelector("[href='\\/frames']");
    By iFrameOption = By.cssSelector("[href='\\/iframe']");

    By textBoxInFrame = By.cssSelector("body#tinymce > p");


    public IFramePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getIFramePage(){
        return driver.findElement(iFramePage);
    }

    public WebElement getIFrameOption(){
        return driver.findElement(iFrameOption);
    }

    public WebElement getTextBoxInFrame(){
        return driver.findElement(textBoxInFrame);
    }

    public void iFrameText(){

        getIFramePage().click();
        getIFrameOption().click();
        driver.switchTo().frame("mce_0_ifr");
        getTextBoxInFrame().clear();
        getTextBoxInFrame().sendKeys("Text is sent");
    }


}
