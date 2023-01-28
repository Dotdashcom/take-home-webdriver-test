package com.anaris.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
     Creating a private constructor, so we are closing access to the object of this class
     from outside any classes
     */
    private Driver(){}

    /*
    Making our 'driver' instance private, so that it is not reachable from outside any class
    We make it static, because we want it to run before anyting else,
    also we will use it in static method
     */
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create re-usable utility method which will return same driver instance when we call it.
     */
    public static WebDriver getDriver(){

        if(driverPool.get() == null){  // if driver/browser was never opened
            String browserType="";
            if(System.getProperty("BROWSER")==null){
                browserType = ConfigurationReader.getProperty("browser");
            }else {
                browserType=System.getProperty("BROWSER");
            }

        /*
        Depending on the browserType our switch statement will determine
        to open specific type of browser/driver
         */
            switch(browserType){
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "54.221.139.255";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {
                        // assign your grid server address
                        String gridAddress = "54.221.139.255";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                //IP --> 44.201.219.205
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions option=new ChromeOptions();
                    option.setHeadless(true);
                    driverPool.set(new ChromeDriver(option));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }

        // Same driver instance will be returned every time we call Driver.getDriver() method
        return driverPool.get();

    }


    public static void closeDriver(){
        if(driverPool.get() != null) {
            driverPool.get().quit(); // this line will kill the session. value will not be null
            driverPool.remove();
        }
    }

}
