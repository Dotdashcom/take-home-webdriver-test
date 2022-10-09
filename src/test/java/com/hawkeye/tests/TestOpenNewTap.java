package com.hawkeye.tests;

import com.hawkeye.pages.OpenNewTabPage;
import com.hawkeye.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestOpenNewTap {

    OpenNewTabPage opn =new OpenNewTabPage();

    @Test
    public void OpenWindowTest()  {

        Driver.getDriver().get("http://localhost:7080/windows");

        Driver.getDriver().manage().window().maximize();


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
