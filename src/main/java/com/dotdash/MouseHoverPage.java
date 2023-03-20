package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MouseHoverPage extends Util{

    protected WebDriver driver;
    
    //selectors
    private By hoverOption = By.cssSelector("[href='\\/hovers']");
    private By userIcons = By.cssSelector("div > img[alt='User Avatar']");
    private By userInfos = By.cssSelector("div > .figcaption > h5");

    
    /**
     * 
     * @param driver
     */
    public MouseHoverPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.findElement(hoverOption).click();
    }
    
    public List<WebElement> getUserIcons(){
        return driver.findElements(userIcons);
    }
    
    public List<WebElement> getUserInfos(){
        return driver.findElements(userInfos);
    }

    public void hoverOverToImage() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        openPage();
        int i = 0;
        for (WebElement element : getUserIcons()) {
            Actions mouseHover = new Actions(driver);
            mouseHover.moveToElement(element).pause(10).perform();
            wait.until(ExpectedConditions.visibilityOf(getUserInfos().get(i)));
            Assert.assertTrue(getUserInfos().get(i).isDisplayed());
            i++;
        }
    }
}