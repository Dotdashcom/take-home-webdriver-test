package com.task.tests;

import com.task.pages.dynamicControlsPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dynamicControlsTest {

    dynamicControlsPage dynamicControlsPage = new dynamicControlsPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/dynamic_controls");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void dynamicControls() {

        dynamicControlsPage.removeButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.addButton));

        System.out.println(dynamicControlsPage.message1.getText());
        Assert.assertEquals(dynamicControlsPage.message1.getText() , "It's gone!");

        dynamicControlsPage.addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.addButton));
        Assert.assertEquals(dynamicControlsPage.message2.getText() , "It's back!");

        dynamicControlsPage.enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.enableButton));

        System.out.println( "message3 :" + dynamicControlsPage.message3.getText());
        Assert.assertEquals( dynamicControlsPage.message3.getText() , "It's enabled!" );

        dynamicControlsPage.disableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.enableButton));
        System.out.println( "message4 :" + dynamicControlsPage.message4.getText());
        Assert.assertEquals( dynamicControlsPage.message4.getText() , "It's disabled!" );

    }











}
