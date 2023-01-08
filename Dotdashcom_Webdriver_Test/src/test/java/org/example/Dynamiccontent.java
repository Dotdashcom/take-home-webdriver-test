package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DropDown;
import pageObjects.DynamicContent;

import java.io.IOException;

public class Dynamiccontent extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "dynamic_content");


    }

    @Test
    public void Dyn() throws InterruptedException {
        DynamicContent d = new DynamicContent(driver);

        String s[]= new String[5];

        for (int i=0;i<3;i++)
        {
            s[i]=d.dynamic().getText();
            System.out.println(s[i]);
            driver.navigate().refresh();
        }
        int j=0;
        Assert.assertNotEquals(s[j],s[++j]);

    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        Thread.sleep(6000);

        driver.close();
    }

}