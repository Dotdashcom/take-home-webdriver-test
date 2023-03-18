package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HoversPage {
    public WebDriver driver;
    public HoversPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindAll(@FindBy(xpath = "//div[@class='example']//div//img"))
    List<WebElement> users;
    @FindAll(@FindBy(xpath = "//*[@id=\"content\"]/div/div"))
    List<WebElement> userInfo;

    public void hoverAndVerifyInfo()  {
        Actions actions = new Actions(driver);
        for (int i =0; i < users.size(); i++ ){
            actions.moveToElement(users.get(i)).perform();
            Assert.assertTrue(userInfo.get(i).isDisplayed());
           // System.out.println(userInfo.get(i).getText());
        }
        }
    }

