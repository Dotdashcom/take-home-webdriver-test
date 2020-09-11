package com.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseClass extends PageInitialisation{


    @BeforeSuite
    public void  BrowserInitialisation(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-download-notification");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.plugins", 1);

        //Setting Up a default download directory for the files
        prefs.put("download.default_directory", DownloadPath);
        prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
        prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
        options.setExperimentalOption("prefs", prefs);

        // invoke Chrome driver based on the Path
        System.setProperty("webdriver.chrome.driver",BrowserPath);
        driver = new ChromeDriver(options);

        //For maximize the window
        driver.manage().window().maximize();

        //Implilcit wait
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite(enabled = false)
    public void TearDown(){
        driver.close();
        driver.quit();
    }

    public void ModuleNavigation(String ModuleName){
        driver.get(BaseURL+ ModuleName);
    }

}
