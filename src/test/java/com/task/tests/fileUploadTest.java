package com.task.tests;

import com.task.pages.fileUploaderPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUploadTest {

    fileUploaderPage fileUploaderPage = new fileUploaderPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/upload");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void fileUploader() throws InterruptedException {

        fileUploaderPage.chooseFile.sendKeys("C:\\Users\\uslub\\Downloads\\some-file.txt");
        Thread.sleep(1000);

        fileUploaderPage.uploadButton.click();

        Thread.sleep(1000);
        String expected = "some-file.txt";
        System.out.println( fileUploaderPage.uploadedFile.getText() );
        Assert.assertEquals( fileUploaderPage.uploadedFile.getText() , expected );

    }




}
