package com.internet.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {
    }

    public synchronized static WebDriver getDriver(String browser) {
        if (driverPool.get() == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    String home = System.getProperty("user.home");
                    String downloadFilepath = home+"/Downloads/";
                    Map<String, Object> chromePrefs = new HashMap<String, Object>();
                    chromePrefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
                    chromePrefs.put("download.prompt_for_download", false);
                    chromePrefs.put("profile.default_content_settings.popups", 0);
                    chromePrefs.put("download.default_directory", downloadFilepath);
                    ChromeOptions dloptions = new ChromeOptions();
                    dloptions.addArguments("use-fake-device-for-media-stream", "use-fake-ui-for-media-stream");
                    dloptions.addArguments("--remote-allow-origins=*");
                    dloptions.setExperimentalOption("prefs", chromePrefs);
                    driverPool.set(new ChromeDriver(dloptions));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge Browser");
                    }
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari Browser");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.setUseTechnologyPreview(true);
                    driverPool.set(new SafariDriver());
                    break;

                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        driverPool.get().manage().window().maximize();
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool!=null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
