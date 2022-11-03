package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class HoversPage extends BasePage {

    public HoversPage(WebDriver driver){

        super(driver);
        driver.get(prop.getProperty("baseurl") + "/hovers");
    }


    public void assertOfAllUsersInformations(){

        List<WebElement> userList = driver.findElements(By.cssSelector("div[class='figure']"));
        int user = 3;

        for (int i = 1; i <= userList.size(); i++){

            WebElement userImg = driver.findElement(By.cssSelector("div[class='figure']:nth-child("+user+") img"));
            WebElement userName = driver.findElement(By.cssSelector("div[class='figure']:nth-child("+user+") h5"));


            Actions action = new Actions(driver);
            action.moveToElement(userImg).build().perform();

            Assert.assertTrue(userName.isDisplayed());



            Assert.assertEquals("name: user"+i+"", userName.getText());

            user++;

        }

    }



}
