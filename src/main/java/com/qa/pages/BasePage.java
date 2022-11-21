package com.qa.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<WebDriver>();
    public static synchronized WebDriver webDriver_init(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            threadDriver.set(new ChromeDriver());
        } else if (browser.equals("safari")) {
            threadDriver.set(new SafariDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.chromedriver().setup();
            threadDriver.set(new FirefoxDriver());
        } else {
            System.out.println("the browser: " + browser + " entered not correct");
        }
        driver=threadDriver.get();
        return driver;
    }

        public static void navigateToSite(String site)
        {
            driver.manage().window().maximize();
            driver.get(site);
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }

        public static void quit()
        {
            driver.close();
            driver.quit();
        }

}
