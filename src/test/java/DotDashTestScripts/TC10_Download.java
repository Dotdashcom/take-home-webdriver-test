package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.DownloadPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

//File Download: http://localhost:7080/download Test File Download.
public class TC10_Download extends baseClass {

    @Test
    public void download() throws AWTException, InterruptedException {
        //Launch url
        driver.get(baseURL+"/download");

        //Create an object for DownloadPage
        DownloadPage downloadPage = new DownloadPage(driver);

        //Click on text file
        downloadPage.clktxtfile();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
        //Check whether the file is downloaded in the given path
        SoftAssert assertion = new SoftAssert();
        if(downloadPage.isFileExists("C:\\Users\\kruti\\Downloads\\some-file.txt") == true)
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! File downloaded successfully!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! File NOT downloaded!!");
        }
    }
}
