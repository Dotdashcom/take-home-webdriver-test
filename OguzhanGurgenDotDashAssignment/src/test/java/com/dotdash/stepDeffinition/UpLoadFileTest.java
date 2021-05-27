package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UpLoadFileTest {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/upload");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void upLoadTest(){

        //Locator of upload button.
        WebElement uploadFileButton = Driver.getDriver().findElement(By.id("file-upload"));

        //path of the file i want to upload from my computer.
        String path = "C:\\Users\\oguzh\\OneDrive\\Pictures\\Screenshots\\funny pic2.PNG";
        uploadFileButton.sendKeys(path);

        //Locator of the uploadButton and I clicked it
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //Locator of the uploaded message
        WebElement uploadedMessage = Driver.getDriver().findElement(By.tagName("h3"));

        //Checking message is appears or not.
        Assert.assertTrue(uploadedMessage.isDisplayed());

    }
}
