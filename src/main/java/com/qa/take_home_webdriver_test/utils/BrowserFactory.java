package com.qa.take_home_webdriver_test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

/**
 * This class creates and returns browsers for each thread.
 *
 * @author Dzmitry Razhkou
 */
public class BrowserFactory {

    // ATTRIBUTES
    private static final ThreadLocal<WebDriver> e_driver = new ThreadLocal<>();

    // METHODS
    public static void setDriver(String browser, boolean headless) {
        switch (browser.trim().toLowerCase()) {
            case "chrome" -> setChromeDriver(headless);
            case "safari" -> safariDriver();
            case "firefox" -> setFirefoxDriver(headless);
            default -> throw new InvalidArgumentException(" =====> Please Provide Another Web Browser!!! <===== ");
        }
    }

    private synchronized static void setChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        e_driver.set(new ChromeDriver(options.setHeadless(headless)));
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        System.out.println(" =====> Selenium Google Chrome <===== ");
    }

    private synchronized static void setFirefoxDriver(boolean headless) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        e_driver.set(new FirefoxDriver(options.setHeadless(headless)));
        System.out.println(" =====> Selenium Marionette Firefox <===== ");

    }

    private synchronized static void safariDriver() {
        WebDriverManager.safaridriver().setup();
        e_driver.set(new SafariDriver());
        System.out.println(" =====> Selenium Apple Safari <===== ");
    }

    public synchronized static WebDriver getDriver() {
        return e_driver.get();
    }

    public synchronized static void removeDriver() {
        e_driver.remove();
    }
}