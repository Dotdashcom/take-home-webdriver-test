package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DynamicContentPage extends BasePage{

    @FindBy (xpath = "//a[@href='/dynamic_content']")
    WebElement link;

    public void clickOnLink(){
        link.click();
    }
    public void checkContent(){
        String text = driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
        driver.navigate().refresh();
        String url = driver.getCurrentUrl();
        driver.navigate().to(url);
        String afterRefreshingText = driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText();
        Assert.assertTrue(!text.equals(afterRefreshingText));
    }
}
