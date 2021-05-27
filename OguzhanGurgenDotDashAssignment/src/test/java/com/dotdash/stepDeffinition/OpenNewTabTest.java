package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class OpenNewTabTest {


    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/windows");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void newTabTest(){

        //Locator of button then I clicked it
        WebElement clickHereButton = Driver.getDriver().findElement(By.xpath("//a[@href='/windows/new']"));
        clickHereButton.click();

        //storing tabs as an arraylist.
        ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());

        Driver.getDriver().switchTo().window(tabs.get(1));

        //Checking any new tab or tabs are opened or not.
        Assert.assertTrue(Driver.getDriver().getTitle().toString().equals("New Window"));


    }


}
