package com.internet.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MouseHoverPage extends BasePage{


    public void checkListOfAvatar (){
        List<WebElement> avatars = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> info = driver.findElements(By.xpath("//div[@class='figure']//h5"));
        for (int i = 0; i < avatars.size(); i++)
            {
            action.moveToElement(avatars.get(i)).pause(2).perform();
            wait.until(ExpectedConditions.visibilityOf(info.get(i)));
                Assertions.assertTrue(info.get(i).isDisplayed());
        }

     }








}
