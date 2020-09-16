package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.io.File;

public class FileDownloadTests extends TestBase {

    /**
     * 10. File Download
     *
     * Test clicks on the file.
     * Test asserts that the file is downloaded.
     * @throws InterruptedException
     */
    @Test
    @DisplayName("Test clicks on the file and asserts that the file is downloaded.")
    public void fileDownloadingTest1() throws InterruptedException {
        Driver.getDriver().findElement(By.linkText("File Download")).click();

        WebElement file = Driver.getDriver().findElement(By.linkText("some-file.txt"));
        file.click();

        String path = System.getProperty("user.home") + "/Downloads/some-file.txt";
        Thread.sleep(2000);
        Assertions.assertTrue(new File(path).exists(), "File does not exist!");
        //cleanup
        new File(path).delete();
    }
}
