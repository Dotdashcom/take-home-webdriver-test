package com.hawkeye.tests;

import com.hawkeye.pages.MouseHoverPage;
import com.hawkeye.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMouseHover {

    MouseHoverPage hover= new MouseHoverPage();

    @Test
    public void HoverTest() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/hovers");

        Driver.getDriver().manage().window().maximize();

        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(2);
        actions.moveToElement(hover.picture1).perform();


        Assert.assertTrue(hover.picture1.isDisplayed(),"name: user1");

        Thread.sleep(2);
        actions.moveToElement(hover.picture3).perform();


        Assert.assertTrue(hover.picture3.isDisplayed(),"name: user3");


        Thread.sleep(2);
        actions.moveToElement(hover.picture2).perform();


        Assert.assertTrue(hover.picture2.isDisplayed(),"name: user2");

        Driver.closeDriver();


    }




}
