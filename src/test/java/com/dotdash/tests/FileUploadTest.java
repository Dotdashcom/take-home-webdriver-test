package com.dotdash.tests;

import com.dotdash.pages.FileUploadPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadTest extends TestBase {


    @Test
    public void fileUploadTest() {

        FileUploadPage fileUploadPage = new FileUploadPage();
        fileUploadPage.navigatePages("File Upload");

        String filePath = "C:\\Users\\AlexaSky\\Desktop\\Oleksandra Pohorielova Resume.pdf";
        fileUploadPage.chooseFile.sendKeys(filePath);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(fileUploadPage.submit));
        fileUploadPage.submit.click();

        Assertions.assertTrue(fileUploadPage.successMsg.isDisplayed());

    }
}
