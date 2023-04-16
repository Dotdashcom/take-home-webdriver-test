package com.dotdash_bozcan.assesmentBusra;
import com.dotdash_bozcan.utilities.ConfigurationReader;
import com.dotdash_bozcan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckandUncheck {
    @BeforeMethod
    public void setUpMethod(){


        Driver.get().get(ConfigurationReader.get("baseUrl") + "/checkboxes");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    @Test
    public void checkAndUncheckBoxesTest(){

        WebElement checkBox1 = Driver.get().findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = Driver.get().findElement(By.xpath("//input[2]"));

        //verify checkbox is selected or not?
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        //verify checkbox 1 is not selected 2 is selected
        Assert.assertFalse(checkBox1.isSelected(),"Verify checkbox 1 is NOT selected");
        Assert.assertTrue(checkBox2.isSelected(),"Verify checkbox 2 is selected");

        checkBox1.click();  //checkBox1 is selected, active
        checkBox2.click();  //checkBox2 is not selected

    }
}
