package com.test.qa.base;

import com.test.qa.utill.TestUtill;
import com.test.qa.utill.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {


    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebDriverWait wait;
    public static WebEventListener eventListener;
    //public static Xls_Reader info = new Xls_Reader("/Users/hiralvaghela/Desktop/Selenium/Selenium_Workspace/AmansonTest/src/main/java/com/amazon/qa/testdata/Amazon_TestData.xlsx");

    public TestBase() {

        try {
            FileInputStream f= new FileInputStream("/Users/hiralvaghela/IdeaProjects/AutomationTest/src/main/java/com/test/qa/config/config.properties");
            prop = new Properties();
            prop.load(f);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {

        String  browserName = prop.getProperty("Browser");

        if(browserName.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/hiralvaghela/Desktop/Selenium/SeleniumJars/geckodriver");
            driver = new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "/Users/hiralvaghela/Desktop/Selenium/SeleniumJars/chromedriver");
            driver = new ChromeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
//        Now create
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;



        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));


        wait = new WebDriverWait(driver, TestUtill.EXPLICIT_WAIT);



    }





}
