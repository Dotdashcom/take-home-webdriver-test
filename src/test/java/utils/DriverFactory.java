package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {
    private static final ThreadLocal<ChromeDriver> DRIVERS = new ThreadLocal<>();

    private DriverFactory() throws Exception {
        throw new Exception();
    }

    public static void setDriver(boolean headless) {
        setChromeDriver(headless);
    }

    private synchronized static void setChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        DRIVERS.set(new ChromeDriver(new ChromeOptions().setHeadless(headless)));
    }

    public synchronized static ChromeDriver getDriver() {
        return DRIVERS.get();
    }

    public synchronized static void removeDriver() {
        DRIVERS.remove();
    }
}