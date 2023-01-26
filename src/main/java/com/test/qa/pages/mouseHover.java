package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class mouseHover extends TestBase
{

    @FindBy(xpath = "//div[@class='figure']")
    List <WebElement> image;
    @FindBy(className = "figcaption")
    List <WebElement> each_image;





    public mouseHover() {
        PageFactory.initElements(driver, this);
    }

    public void mouseAction() {

        for(int i = 0; i<=image.size()-1;i++) {
            Actions act = new Actions(driver);
            act.moveToElement(image.get(i)).build().perform();
            Assert.assertEquals(each_image.get(i).isDisplayed(), true, "no additional informations displayed");
        }
    }
}

