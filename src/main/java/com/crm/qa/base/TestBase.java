package com.crm.qa.base;

//import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver = new ChromeDriver();
    static Properties prop;

    public TestBase(){
            try{
                prop = new Properties();
                FileInputStream ip = new FileInputStream("C:\\Users\\user\\Desktop\\JAVA\\seleniumproject\\src\\main\\java\\com\\crm" +
                        "\\qa\\config\\config.properties");
                prop.load(ip);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public static void initialization(){
         String browserName = prop.getProperty("browser");
         if (browserName.equals("chrome")){
              driver = new ChromeDriver();
         } else if (browserName.equals("FF")){
             driver = new FirefoxDriver();
         }
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.get(prop.getProperty("url"));

    }




}
