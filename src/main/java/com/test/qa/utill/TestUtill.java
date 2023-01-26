package com.test.qa.utill;

import com.test.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;



public class TestUtill extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 50;
    public static long EXPLICIT_WAIT = 20;
    public static void takeScreenshotAtEndOfTest() throws IOException  {

        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");

        FileUtils.copyFile(scrfile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

    }
}

