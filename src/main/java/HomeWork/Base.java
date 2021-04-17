package HomeWork;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {

    public WebDriver driver;
    private ChromeOptions options;
//    private String path = System.getProperty("user.dir");

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/andriionishchuk/IdeaProjects/take-home-webdriver-test/src/main/java/HomeWork/Data.properties");
        properties.load(fileInputStream);
        String  browserName = properties.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){

//            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//            chromePrefs.put("profile.default_content_settings.popups", 0);
//            chromePrefs.put("download.default_directory", path);
//
//            options = new ChromeOptions();
//            options.setExperimentalOption("prefs",chromePrefs);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

//    public String getPath() {
//        return path;
//    }

}
