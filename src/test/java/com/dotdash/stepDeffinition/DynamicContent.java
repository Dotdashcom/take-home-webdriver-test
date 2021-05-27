package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DynamicContent {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/dynamic_content");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void dynamicContentTest() {
        // here we stored each images texts
        List<WebElement> images = Driver.getDriver().findElements(By.xpath("//div[@class='large-10 columns']"));

        String text1 = images.get(0).getText();
        String text2 = images.get(1).getText();
        String text3 = images.get(2).getText();


        WebElement refreshButton = Driver.getDriver().findElement(By.xpath("//a[@href='/dynamic_content?with_content=static']"));
        refreshButton.click(); // here we click the click here button after that top two image stays static and last image changes


        Driver.getDriver().navigate().refresh(); //after click here button we refresh the page

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(refreshButton)); // wait for refreshing the page

        Driver.getDriver().navigate().refresh(); // refresh the page again


        // here storing after refreshing the page storing last image's text
        List<WebElement> images2 = Driver.getDriver().findElements(By.xpath("//div[@class='large-10 columns']"));
        String text4 = images2.get(2).getText();
        System.out.println("text4 = " + text4);

        //here I'm checking last image's text are not same. Because after refreshing the page only part is changing is last image and its text.
        Assert.assertTrue(!text3.equals(text4));



    }


}





