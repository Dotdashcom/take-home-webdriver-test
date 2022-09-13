package com.project.tests;

import com.project.pages.OpenNewTabPage;
import com.project.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class OpenNewWindow {

    OpenNewTabPage open =new OpenNewTabPage();

    @Test
    public void OpenWindowTest()  {

        Driver.getDriver().get("http://localhost:7080/windows");

        Driver.getDriver().manage().window().maximize();

        open.clickButton.click();

        Driver.getDriver().getWindowHandles();

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for(String each: allWindowHandles){

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current title while switching windows: " + Driver.getDriver().getTitle());

        }


        Assert.assertEquals(Driver.getDriver().getTitle(),"New Window");


        Driver.closeDriver();


    }

}
