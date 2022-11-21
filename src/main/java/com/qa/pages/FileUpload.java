package com.qa.pages;

import org.openqa.selenium.By;

public class FileUpload extends BasePage{

    By chooseFile= By.id("file-upload");
    By uploadBtn= By.id("file-submit");
    By uploadSuccess=By.cssSelector("#uploaded-files");


    public boolean uploadfile(String fileLocation)
    {
        Utility.wait(driver.findElement(chooseFile));
        driver.findElement(chooseFile).click();
        driver.findElement(chooseFile).sendKeys(fileLocation);
        Utility.wait(driver.findElement(uploadBtn));
        driver.findElement(uploadBtn).click();
        return driver.findElement(uploadSuccess).isDisplayed();

    }




}
