package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FloatingMenuPage extends BasePage{

    @FindBy(xpath = "//a[@href='/floating_menu']")
    WebElement link;

    @FindBy(xpath = "//div[@style='text-align: center;']")
    WebElement lastElement;

    @FindBy(xpath = "//div[@class='example']/h3")
    WebElement floatingMenu;

    public void clickOnLink(){
        link.click();
    }
    public void verifyFloatingMenu(){
        Actions actions = new Actions(driver);
        actions.moveToElement(lastElement).perform();
        Assert.assertTrue(floatingMenu.isDisplayed());
    }
}
