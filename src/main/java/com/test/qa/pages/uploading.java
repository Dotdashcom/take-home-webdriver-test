package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class uploading extends TestBase {

    @FindBy(xpath = "//*[@id=\"file-upload\"]")
    WebElement file_upload;

    @FindBy(xpath = "//*[@id=\"file-submit\"]")
    WebElement uplaod_button;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    WebElement uploading_confirmation;
    @FindBy(xpath = "//*[@id=\"uploaded-files\"]")
    WebElement uploading_same_file;

    public uploading() {
        PageFactory.initElements(driver, this);
    }

    public void fileUploading() throws InterruptedException {

        file_upload.sendKeys("/Users/hiralvaghela/Downloads/some-file.txt");
        Thread.sleep(2000);
        uplaod_button.click();
        String uploading_confirmation_actual = uploading_confirmation.getText();
        String uploaded_confirmation_expected = "File Uploaded!";
        String uploading_same_file_actual = uploading_same_file.getText();
        String uploading_same_file_expected = "some-file.txt";
        Assert.assertEquals(uploading_confirmation_actual, uploaded_confirmation_expected, "didn't uploaded");
        Assert.assertEquals(uploading_same_file_actual, uploading_same_file_expected, "didn't uploaded");
    }

}
