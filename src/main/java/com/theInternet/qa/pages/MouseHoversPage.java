package com.theInternet.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MouseHoversPage {
	 WebDriver driver;

    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> images;

    @FindBy(xpath = "//h5[contains(text(),'name: user')]")
    public WebElement username_txt;

    @FindBy(xpath = "//a[contains(text(),'View profile')]")
    public WebElement viewProfile_txt;


    public MouseHoversPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void VerifyMousehoverText() {
        Actions action = new Actions(driver);
        for(WebElement ele:images)
        {
            action.moveToElement(ele).build().perform();
                       Assert.assertTrue( 
            		viewProfile_txt.isDisplayed(),"additional info not displayed on this hover.");
        }
    }

}
