package com.dotdash.utils.drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;

public class OptionsManager {

    private OptionsManager() {
        throw new IllegalStateException("OptionsManager class");
    }

    private static final String DOWNLOAD_PATH = System.getProperty("user.dir") + File.separator + Paths.get("src", "main", "resources");

    public static ChromeOptions getChromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", DOWNLOAD_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions geckoOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        geckoOptions.setLogLevel(FirefoxDriverLogLevel.ERROR);
        geckoOptions.addArguments("--headless");
        geckoOptions.addArguments("-width=1920");
        geckoOptions.addArguments("-height=1080");
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", DOWNLOAD_PATH);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
        geckoOptions.setProfile(profile);
        return geckoOptions;
    }
}
