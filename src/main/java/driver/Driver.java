package driver;

import browsers.BrowserType;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.logging.Level;

import logging.Logging;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static java.util.concurrent.TimeUnit.SECONDS;
import static properties.TestProperties.TEST_PROPERTIES;

public final class Driver implements Logging {

    private static final String DOWNLOADS_DIR = "downloads";
    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    public static void populateDriver(BrowserType browser) throws MalformedURLException {
        if (DRIVERS.get() == null) {
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("download.default_directory", Paths.get(DOWNLOADS_DIR).toAbsolutePath().toString());
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.merge(browser.getCapabilities());

            WebDriver webDriver = new RemoteWebDriver(new URL(TEST_PROPERTIES.getRemoteServerUrl()), capabilities);
            webDriver.manage().timeouts().pageLoadTimeout(TEST_PROPERTIES.getPageLoadTimeout(), SECONDS);
            webDriver.manage().timeouts().setScriptTimeout(TEST_PROPERTIES.getScriptTimeout(), SECONDS);
            webDriver.manage().timeouts().implicitlyWait(TEST_PROPERTIES.getImplicitWait(), SECONDS);
            webDriver.manage().window().maximize();
            webDriver.get(TEST_PROPERTIES.getBaseUrl());
            DRIVERS.set(webDriver);
        }
    }

    /**
     * Gets the instance previously created and stored at thread-level of the getDriver.
     *
     * @return the {@link Driver}
     */
    public static WebDriver getDriver() {
        return DRIVERS.get();
    }

    /**
     * Dispose the getDriver, releasing the session between the client and the server.
     * The platform will be closed.
     */
    public static void dispose() {
        DRIVERS.get().quit();
        DRIVERS.remove();
    }
}
