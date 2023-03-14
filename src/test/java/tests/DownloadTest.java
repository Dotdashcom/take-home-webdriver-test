package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class DownloadTest {

    private static WebDriver driver;
    private static String URL = "";

    @Before
    public void beforeStart() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        EnvironmentManager.initWebDriverWithOptions(options);
        driver = RunEnvironment.getWebDriver();
        URL = RunEnvironment.getUrlBase();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void downloadFile() {

        boolean fileExist = false;
        File fileToDelete = null;

        driver.get(URL + "/download");

        try {

            WebElement file = driver.findElement(
                    By.cssSelector("div.example>a"));

            //Downloading file
            file.click();
            Thread.sleep(4000);

            //start : Validating and Deleting file
            File folder = new File(System.getProperty("user.dir"));

            File[] listOfFiles = folder.listFiles();

            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    String fileName = listOfFile.getName();
                    if (fileName.matches(file.getText())) {
                        fileToDelete = new File(fileName);
                        fileExist = true;
                    }

                }
            }
            //end : Validating and Deleting file

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());

        }

        assertTrue(fileExist);
        fileToDelete.deleteOnExit();

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
