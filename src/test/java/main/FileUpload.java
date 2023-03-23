package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FileUpload extends Constants{

    @Test
    public void uploadFilePractice() throws AWTException, InterruptedException {
        driver.get("http://localhost:7080/upload");

        String fileName = "some-file.txt";

        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        Actions a = new Actions(driver);
        a.moveToElement(fileUpload).click().perform();

        Robot r = new Robot();

        Thread.sleep(1000);

        r.keyPress(KeyEvent.VK_META);
        r.delay(500);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_META);
        r.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(500);


       //    path: /Users/mo/Downloads/some-file.txt // Modify the path ...
        r.keyPress(KeyEvent.VK_SLASH);
        r.keyPress(KeyEvent.VK_U);

        r.keyRelease(KeyEvent.VK_U);
        r.keyPress(KeyEvent.VK_S);
        r.keyRelease(KeyEvent.VK_S);
        r.keyPress(KeyEvent.VK_E);
        r.keyRelease(KeyEvent.VK_E);
        r.keyPress(KeyEvent.VK_R);
        r.keyRelease(KeyEvent.VK_R);
        r.keyPress(KeyEvent.VK_S);
        r.keyRelease(KeyEvent.VK_S);
        r.keyPress(KeyEvent.VK_SLASH);
        r.keyRelease(KeyEvent.VK_SLASH);
        r.keyPress(KeyEvent.VK_M);
        r.keyRelease(KeyEvent.VK_M);
        r.keyPress(KeyEvent.VK_O);
        r.keyRelease(KeyEvent.VK_O);
        r.keyPress(KeyEvent.VK_SLASH);
        r.keyRelease(KeyEvent.VK_SLASH);
        r.keyPress(KeyEvent.VK_D);
        r.keyRelease(KeyEvent.VK_D);
        r.keyPress(KeyEvent.VK_O);
        r.keyRelease(KeyEvent.VK_O);
        r.keyPress(KeyEvent.VK_W);
        r.keyRelease(KeyEvent.VK_W);
        r.keyPress(KeyEvent.VK_N);
        r.keyRelease(KeyEvent.VK_N);
        r.keyPress(KeyEvent.VK_L);
        r.keyRelease(KeyEvent.VK_L);
        r.keyPress(KeyEvent.VK_O);
        r.keyRelease(KeyEvent.VK_O);
        r.keyPress(KeyEvent.VK_A);
        r.keyRelease(KeyEvent.VK_A);
        r.keyPress(KeyEvent.VK_D);
        r.keyRelease(KeyEvent.VK_D);
        r.keyPress(KeyEvent.VK_S);
        r.keyRelease(KeyEvent.VK_S);
        r.keyPress(KeyEvent.VK_SLASH);
        r.keyRelease(KeyEvent.VK_SLASH);
        r.keyPress(KeyEvent.VK_S);
        r.keyRelease(KeyEvent.VK_S);
        r.keyPress(KeyEvent.VK_O);
        r.keyRelease(KeyEvent.VK_O);
        r.keyPress(KeyEvent.VK_M);
        r.keyRelease(KeyEvent.VK_M);
        r.keyPress(KeyEvent.VK_E);
        r.keyRelease(KeyEvent.VK_E);
        r.keyPress(KeyEvent.VK_MINUS);
        r.keyRelease(KeyEvent.VK_MINUS);
        r.keyPress(KeyEvent.VK_F);
        r.keyRelease(KeyEvent.VK_F);
        r.keyPress(KeyEvent.VK_I);
        r.keyRelease(KeyEvent.VK_I);
        r.keyPress(KeyEvent.VK_L);
        r.keyRelease(KeyEvent.VK_L);
        r.keyPress(KeyEvent.VK_E);
        r.keyRelease(KeyEvent.VK_E);
        r.keyPress(KeyEvent.VK_PERIOD);
        r.keyRelease(KeyEvent.VK_PERIOD);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_T);
        r.keyPress(KeyEvent.VK_X);
        r.keyRelease(KeyEvent.VK_X);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_T);
        r.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(200);
        r.keyRelease(KeyEvent.VK_ENTER);

        r.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(200);
        r.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(500);

        WebElement submitFile = driver.findElement(By.id("file-submit"));
        submitFile.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        String UploadedFileName = uploadedFile.getText();
        sa.assertEquals(UploadedFileName, fileName );

        sa.assertAll();
    }
}
