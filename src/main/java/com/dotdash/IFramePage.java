package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramePage extends Util{

    protected WebDriver driver;
    
    //selectors
    private By iFramePage = By.cssSelector("[href='\\/frames']");
    private By iFrameOption = By.cssSelector("[href='\\/iframe']");
    private By textBoxInFrame = By.cssSelector("body#tinymce > p");

    
    /***
     * 
     * @param driver
     */
    public IFramePage(WebDriver driver){
        this.driver = driver;
    }

    public void openIFramePage(){
        driver.findElement(iFramePage).click();
    }

    public void openIFrameOption(){
        driver.findElement(iFrameOption).click();
    }

    public WebElement getTextBoxInFrame(){
        return driver.findElement(textBoxInFrame);
    }

    public void iFrameText(){

        openIFramePage();
        openIFrameOption();
        driver.switchTo().frame("mce_0_ifr");
        getTextBoxInFrame().clear();
        getTextBoxInFrame().sendKeys("Text is sent");
    }


}