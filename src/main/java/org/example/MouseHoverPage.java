package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MouseHoverPage extends BasePage{

    protected WebDriver driver;

    By hoverOption = By.cssSelector("[href='\\/hovers']");
    By userIcons = By.cssSelector("div > img[alt='User Avatar']");
    By userInfos = By.cssSelector("div > .figcaption > h5");


    public MouseHoverPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getHoverPage(){
        return driver.findElement(hoverOption);
    }
    public List<WebElement> getUserIcons(){
        return driver.findElements(userIcons);
    }
    public List<WebElement> getUserInfos(){
        return driver.findElements(userInfos);
    }


    public void hoverOverToImage() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        getHoverPage().click();
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
