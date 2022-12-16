package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 Test clicks on the file.
 Test asserts that the file is downloaded.
 */

public class TestCase10FileDownload {

    @Test
    public void fileDownload() {

        Driver.getDriver().get("http://localhost:7080/download ");

        // link "some-file.txt"
        Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/a")).click();

        //we use import java.io.File;
        File file = new File("/Users/victorvladovskiy/Downloads");

        Assert.assertTrue(file.exists(),"asserts that the file is downloaded");

        Driver.closeDriver();
        //

    }
}
