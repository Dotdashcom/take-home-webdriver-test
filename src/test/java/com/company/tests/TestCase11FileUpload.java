package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 Test uses Upload Button or Drag and Drop to upload a file.
 Test asserts that the file is uploaded.
 */

public class TestCase11FileUpload {

    @Test
    public void upload_file_test() {

        Driver.getDriver().get("http://localhost:7080/upload");

        WebElement chooseFileElem = Driver.getDriver().findElement(By.xpath("//*[@id='file-upload']"));
        chooseFileElem.sendKeys("/Users/victorvladovskiy/IdeaProject/take-home-webdriver-test/src/test/resources/test.txt");

        WebElement uploadBtn = Driver.getDriver().findElement(By.cssSelector("#file-submit"));
        uploadBtn.click();

        WebElement resultMsg = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/h3"));
        String actualResultMsg = resultMsg.getText();
        String expectedResultMsg = "File Uploaded!";

        Assert.assertEquals(actualResultMsg,expectedResultMsg,"Result message verification failed!");

        Driver.closeDriver();
    }
}
