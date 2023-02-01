package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import java.io.File;

public class FileDownloadPage extends BasePage{
    public FileDownloadPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//a[normalize-space()='some-file.txt']")
    private WebElement fileLink;

    public void verifyDownloadFile() throws InterruptedException {
        btnClick(fileLink);
        File file = new File(System.getProperty("user.home") + "/Downloads/" + fileLink.getText().trim());
        Thread.sleep(5000);
        softAssert.assertTrue(file.exists(),"File is not exists in " + file.getAbsolutePath());
    }

}
