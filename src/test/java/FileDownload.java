import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class FileDownload {

WebDriver driver;

    @BeforeMethod
    public void getDriver() {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);

    }

    @Test
    public void fileDownload() throws InterruptedException {

        driver.get("http://localhost:7080/download");

        WebElement image = driver.findElement(By.xpath("//*[@class='example']/a"));
        String downloadFileName = image.getText();
        System.out.println(downloadFileName);
        image.click();

    File folder = new File(System.getProperty("user.dir"));
    Thread.sleep(3000);
    File[] listOfFiles = folder.listFiles();
    boolean found = false;
    File f = null;
        for (File listOfFile : listOfFiles) {
        if (listOfFile.isFile()) {
            String fileName = listOfFile.getName();
            if (fileName.matches(downloadFileName)) {
                f = new File(fileName);
                found = true;
            }
        }
    }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
}

@AfterMethod
public void tearDown() {
    driver.quit();
}

}
