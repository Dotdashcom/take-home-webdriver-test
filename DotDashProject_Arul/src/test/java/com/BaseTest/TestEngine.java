package com.BaseTest;

import com.Repository.ValueRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestEngine extends ValueRepository {


    @BeforeSuite(enabled = true)
    public void TestInitialisation(){


        ChromeOptions options = new ChromeOptions();
        //provide path to which files can download
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", prefs);

        //Provide path where chromedriver exe file is located
        System.setProperty("webdriver.chrome.driver",browserPath);
        //open the chrome browser
        driver = new ChromeDriver(options);
        //maximize the browser
        driver.manage().window().maximize();
        //implicit wait time for every test case line implementation
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @AfterSuite(enabled = false)
    public  void TestClosure(){
        //close the browser on focus
        driver.close();
        //close the entire browser session
        driver.quit();
    }
}