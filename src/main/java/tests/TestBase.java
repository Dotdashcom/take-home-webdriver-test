package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.utils;

public class TestBase {
    private static ThreadLocal<TestBase> TestBase = new ThreadLocal<TestBase>();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    protected TestBase() {
        System.out.println("Intiallization singlton class .....");
    }

    public static TestBase getInstance() {
        if (TestBase.get() == null) {
            TestBase.set(new TestBase());
            setDriver();
        }
        return TestBase.get();
    }

    private static void setDriver() {
        switch (utils.browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                System.out.println("Driver intialzed by " + Thread.currentThread().getId() + " with reference as " + driver.get());

                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                System.out.println("Driver intialzed by " + Thread.currentThread().getId() + " with reference as " + driver.get());

                break;
            default:

                break;
        }
    }

    public WebDriver getDriver() {

        return driver.get();
    }

}