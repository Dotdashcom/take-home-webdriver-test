package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.io.File;
import java.io.IOException;
@Test
public class FileDownloadTest extends CommonMethods {
    public static void main(String[] args) throws InterruptedException, IOException {
        setUp("http://localhost:7080/download");
        String downloadPath = "/Users/artyomburenko/Downloads";

        WebElement link = driver.findElement(By.xpath("//a[contains(text(), 'some')]"));
        link.click();

        Assert.assertTrue(isFileDownloaded(downloadPath, "some-file.txt"), "Failed to download the file");
        System.out.println("The test is passed. The file is downloaded");
        tearDown();
    }

    //Method to verify if the file is downloaded
    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }
        return flag;
    }
}
