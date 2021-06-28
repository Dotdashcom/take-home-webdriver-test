package com.task.tests;

import com.task.pages.checkBoxPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkBoxTest {

    checkBoxPage checkBoxPage = new checkBoxPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/checkboxes");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void checkboxes(){

        if ( !checkBoxPage.checkBox1.isSelected() ) {
            System.out.println( "checkbox 1 is not selected. verification PASSED!!!" );
        } else {
            System.out.println( "checkbox 1 is selected. verification FAILED!!!" );
        }

        if ( checkBoxPage.checkBox2.isSelected() ) {
            System.out.println( "checkbox 2 is selected. verification PASSED!!!" );
        } else {
            System.out.println( "checkbox 2 is not selected. verification FAILED!!!" );
        }
        Assert.assertEquals( !checkBoxPage.checkBox1.isSelected() , true);
        Assert.assertTrue( checkBoxPage.checkBox2.isSelected() );

    }
}
