package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class dragAndDrop extends TestBase {


             @FindBy(xpath = "//div[@id='column-a']")
             WebElement Box1;

             @FindBy(xpath = "//div[@id='column-b']")
             WebElement Box2;

    public dragAndDrop() {
        PageFactory.initElements(driver, this);
    }

    public void dargDrop() throws InterruptedException {


        Actions action = new Actions(driver);

        wait.until(ExpectedConditions.visibilityOf(Box1));

        Thread.sleep(2000);
        action.dragAndDrop(Box1, Box2).build().perform();




    }

}
