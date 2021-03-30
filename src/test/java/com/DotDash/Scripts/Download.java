package com.DotDash.Scripts;

import com.DotDash.Pages.DownloadPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Download extends basePage {

    @Test
    public void download() throws AWTException, InterruptedException {
        driver.get(baseURL + "/download");

        DownloadPage downloadPage = new DownloadPage(driver);

        downloadPage.clktxtfile();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(downloadPage.isFileExists("C:\\Users\\jhryj\\Downloads\\some-file.txt"));

        assertion.assertAll();
    }
}
