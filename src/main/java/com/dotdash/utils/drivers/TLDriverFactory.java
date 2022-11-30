package com.dotdash.utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TLDriverFactory {

    private TLDriverFactory() {
        throw new IllegalStateException("TLDriverFactory class");
    }

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    public static synchronized void setTLDriver(String browser) {
        if (browser.equals("firefox")) {
            tlDriver.set(ThreadGuard.protect(new FirefoxDriver(OptionsManager.getFirefoxOptions())));
        } else if (browser.equals("chrome")) {
            tlDriver.set(ThreadGuard.protect(new ChromeDriver(OptionsManager.getChromeOptions())));
        }
    }

    public static synchronized WebDriver getTLDriver() {
        return tlDriver.get();
    }

    public static synchronized void flushTLDriver() {tlDriver.remove();}
}
