package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Constants;

import java.io.File;

public class DownloadFile extends Constants {

    static String url = "http://localhost:7080/download";


    @Test
    public static void testDownload() {
        driver.get(url);

        WebElement downloadLink = driver.findElement(By.linkText("some-file.txt"));
        downloadLink.click();
        String fileName = "some-file.txt";
        String downloadPath = "/Users/mo/Downloads"; // modify the path depending on your downloads path on your machine.
            File dir = new File(downloadPath);
            File[] dirContents = dir.listFiles();
            boolean found = false;
            for (int i = 0; i < dirContents.length; i++) {
                if (dirContents[i].getName().equals(fileName)) {
                    found = true;
                    break;
                }
            }
            sa.assertEquals(found, true);

        sa.assertAll();
    }
}
