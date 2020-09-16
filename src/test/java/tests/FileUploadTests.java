package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.io.File;
import java.io.IOException;

public class FileUploadTests extends TestBase{

    /**
     * 11. File Upload
     *
     * Test uses Upload Button or Drag and Drop to upload a file.
     * Test asserts that the file is uploaded.
     * @throws InterruptedException
     */
    @Test
    @DisplayName("Test uses Upload Button or Drag and Drop to upload a filr and that the file is uploaded.")
    public void fileUploadingTest() throws InterruptedException {
        Driver.getDriver().findElement(By.linkText("File Upload")).click();
        String path = System.getProperty("user.home") + "/Downloads/some-file.txt";
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));
        WebElement fileSubmit = Driver.getDriver().findElement(By.id("file-submit"));
        fileUpload.sendKeys(path);
        fileSubmit.click();

        Thread.sleep(2000);
        String actual = Driver.getDriver().findElement(By.id("uploaded-files")).getText().trim();
        String expected = "some-file.txt";
        Assertions.assertEquals(expected, actual, "File name is not correct!");
    }
}
