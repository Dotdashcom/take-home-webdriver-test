package environment;

import org.openqa.selenium.WebDriver;

public class RunEnvironment {

    private static WebDriver webDriver;
    private static String urlBase;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    static void setWebDriver(WebDriver webDriver) {
        RunEnvironment.webDriver = webDriver;
    }

    public static String getUrlBase() {
        return urlBase;
    }

    public static void setUrlBase(String urlBase) {
        RunEnvironment.urlBase = urlBase;
    }
}