package com.DotDash.Scripts;

import com.DotDash.BasePage.basePage;
import com.DotDash.Pages.UploadPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UploadFileTest extends basePage {

    @Test
    public void uploadFile() throws InterruptedException {
        driver.get(baseURL+"/upload");

        UploadPage uploadPage = new UploadPage(driver);

        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB);
        act.sendKeys(Keys.TAB);
        act.sendKeys(Keys.ENTER);

        uploadPage.btnChoosefile.sendKeys("C:\\Users\\jhryj\\Downloads\\some-file.txt");

        uploadPage.clkbtnUpload();

        Thread.sleep(2000);

        SoftAssert assertion = new SoftAssert();
        if(uploadPage.gettxtFileUpload().equals("File Uploaded!"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! File is successfully uploaded!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! File is NOT uploaded!!");
        }
        assertion.assertAll();
    }
}

