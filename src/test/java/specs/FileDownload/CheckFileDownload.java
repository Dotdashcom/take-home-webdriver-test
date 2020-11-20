package specs.FileDownload;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

import java.io.File;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #10 File Download: http://localhost:7080/download Test File Download
public class CheckFileDownload extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 5000;
    private static By bySomeFile = By.xpath("//a[contains(text(), 'some-file.txt')]");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/download");
    }

    @Test
    public void checkFileDownload() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        String downloadPath = System.getProperty("user.home")+"/Downloads/";

        driver.findElement(bySomeFile).click();

        Thread.sleep(DEFAULT_PAUSE);

        softas.assertTrue(isFileDownloaded(downloadPath, "some-file.txt"), "File downloading failed");

        softas.assertAll();
    }

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag=true;
        }

        return flag;
    }

}
