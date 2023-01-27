package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Screenshot {
    public static String takeScreenshot(WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = new byte[0];

        try {
            fileContent = FileUtils.readFileToByteArray(scrFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
    }

    private Object webdriver;
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
}