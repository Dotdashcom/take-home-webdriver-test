package com.task.tests;

import com.task.pages.dropdownPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dropdownTest {

    dropdownPage dropdownPage = new dropdownPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/dropdown");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void dropdown() throws InterruptedException {
        Select firstOption = new Select(dropdownPage.option1);

        firstOption.selectByVisibleText("Option 1");

        String actualResult1 = "Option 1";
        String expectedResult1 = firstOption.getFirstSelectedOption().getText();
        System.out.println(expectedResult1);

        Assert.assertEquals( actualResult1 , expectedResult1 );

        Thread.sleep(2000);

        Select secondOption = new Select(dropdownPage.option2);

        secondOption.selectByVisibleText("Option 2");

        String actualResult2 = "Option 2";
        String expectedResult2 = secondOption.getFirstSelectedOption().getText();

        Assert.assertEquals( actualResult2 , expectedResult2 );

    }





}
