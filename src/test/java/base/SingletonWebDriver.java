package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class SingletonWebDriver {

    private static final String WEBDRIVER_STRING = "webdriver.chrome.driver";
    //private static final String WEBDRIVER_LOCATION = "src/test/testresources/chromedriver-v85.exe";
    private static final String WEBDRIVER_LOCATION = "src/test/testresources/chromedriver"; //for ubutu

    // instance of singleton class
    private static SingletonWebDriver instance=null;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    // Constructor
    private SingletonWebDriver(){
        System.setProperty(WEBDRIVER_STRING, WEBDRIVER_LOCATION);
        driver= new ChromeDriver();
    }

    private SingletonWebDriver(String defaultDownloadLocation){
        System.setProperty(WEBDRIVER_STRING, WEBDRIVER_LOCATION);
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", defaultDownloadLocation);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver= new ChromeDriver(cap);
    }

    // create instance of class
    public static SingletonWebDriver getInstanceOfSingletonBrowser(){
        if(instance==null){
            instance = new SingletonWebDriver();
        }
        return instance;
    }

    // create instance of class
    public static SingletonWebDriver getInstanceOfSingletonBrowser(String defaultDownloadLocation){
        if(instance==null){
            instance = new SingletonWebDriver(defaultDownloadLocation);
        }
        return instance;
    }

    public void destroy() {
        instance = null;
        driver.close();
        driver.quit();
    }

    // To get driver
    public WebDriver getDriver() {
        return driver;
    }
}
