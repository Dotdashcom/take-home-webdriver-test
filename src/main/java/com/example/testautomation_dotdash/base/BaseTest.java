package com.example.testautomation_dotdash.base;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public static Properties prop;

    private String downloadFilePath;

    public BaseTest(){
        try {
            prop = new Properties();
            FileInputStream config = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/example/testautomation_dotdash/" +
                    "config/config.properties");
            prop.load(config);
            downloadFilePath =  prop.getProperty("downloadFilePath");

            setup();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setup(){
        String browserName = prop.getProperty("browser");

        switch (browserName) {

//            case "Firefox":
//                System.setProperty("webdriver.gecko.driver", "src/main/resources/com/example/testautomation_dotdash/appdriver/geckodriver");
//                driver = new FirefoxDriver();
//                break;

            default:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/com/example/testautomation_dotdash/appdriver/chromedriver");

                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory",System.getProperty("user.dir") + "/src/main/resources/file_storage");

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(options);
                break;
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(prop.getProperty("baseurl"));
    }

    public boolean isFileDownloaded(String fileName) {
        File dir = new File(downloadFilePath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
//                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @After
    public void killDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
