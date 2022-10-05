package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dotdash.pages.FileUploadPage;


public class Test_11_FileUpload extends TestBase {
    @Test
    public void file_upload_test() {

        FileUploadPage fileUploadPage = new FileUploadPage();
        fileUploadPage.navigatePages("File Upload");
        String filePath = "C:\\Users\\netta\\IdeaProjects\\take-home-webdriver-test\\src\\test\\java\\com\\dotdash\\files_download\\cat.jpg";
        fileUploadPage.chooseFile.sendKeys(filePath);
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(fileUploadPage.submit));
        fileUploadPage.submit.click();

        Assertions.assertTrue(fileUploadPage.successMsg.isDisplayed());

    }
}
