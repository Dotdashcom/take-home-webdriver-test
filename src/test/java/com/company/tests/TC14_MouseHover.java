package com.company.tests;

import com.company.base.TestBase;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC14_MouseHover extends TestBase {

    @Test
    public void google_actions_hover_test() throws InterruptedException {

        //    1. Go to https://www.google.com
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

//    2. Hover over on Search button
//        3. Hover over on Feeling Lucky button
        WebElement searchBtn = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement feelingLuckyBtn = Driver.getDriver().findElement(By.id("gbqfbb"));

        Actions actions = new Actions(Driver.getDriver());
        // hover over method is moveToElement()
        Thread.sleep(3000);
        actions.moveToElement(searchBtn).perform();
        Thread.sleep(3000);
        actions.moveToElement(feelingLuckyBtn).perform();


//

    }
}
