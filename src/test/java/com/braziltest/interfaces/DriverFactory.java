package com.braziltest.interfaces;

import com.braziltest.Steps.Hook.Hook;
import com.vimalselvam.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import static com.braziltest.Utils.Config.*;


public class DriverFactory extends Hook {


    private static String path = "";
    private static String url = "";
    private static WebElement element = null;
    private static int id = 0;
    public static String browser;
    public static String scenarioName;
    public static String executionFolder;

    private int linha = 0;
    private String ExecutionFolder = LocalDateTime.now().toString().replaceAll(":", "").replace("-", "").replace(".",
            "");

        public static WebDriver getDriver(String arg0) throws Exception {

            if (PLATFORMTYPE.toUpperCase().equals("WEB")) {
                if (BROWSERTESTING.equals("CHROME")) {
                    if (System.getProperty("os.name").contains("Windows")) {
                        System.out.println(System.getProperty("os.name"));
                        OpenBrowserChrome(arg0, DRIVERPATHCHROMEWIN);
                    }

                    if (System.getProperty("os.name").contains("Linux")) {
                        System.out.println(System.getProperty("os.name"));
                        OpenBrowserChrome(arg0, DRIVERPATHCHROMELIN);

                    }
                }
                if (BROWSERTESTING.equals("FIREFOX")) {
                    if (System.getProperty("os.name").contains("Windows")) {
                        OpenBrowserFirefox(arg0, DRIVERPATHFFOXWIN);
                    }
                    if (System.getProperty("os.name").contains("Linux")) {
                        System.out.println(System.getProperty("os.name"));
                        OpenBrowserFirefox(arg0, DRIVERPATHFFOXLIN);

                    }
                }
            }
            return Webdriver;
        }


    /*************************************************************
     * INSTANTIATE A NEW DRIVER WEB
     ****************************************************************/
    public static WebDriver OpenBrowserChrome(String p0,String Path) throws Exception {
        System.setProperty("webdriver.chrome.driver", Path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        Webdriver = new ChromeDriver(options);
        Webdriver.get(p0);
        Webdriver.manage().window().maximize();
        return Webdriver;
    }


    public static WebDriver OpenBrowserFirefox(String p0,String Path) throws InterruptedException {
       System.setProperty("webdriver.gecko.driver",Path);
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to(p0);
        driver.manage().timeouts().implicitlyWait(TIMEOUTAUTOMATION, TimeUnit.SECONDS);
        Webdriver = (RemoteWebDriver) driver;
        return Webdriver;
    }

    /*************************************************************
     * EVIDENCIAS SCREENSHOTS
     ****************************************************************/
    public static void Evidencia(WebDriver driver) throws IOException {
        if(EvidenceGen.equals("S")) {
            //evidence picture report
            id = id + 1;
            String pathCucumber = "";
            if(System.getProperty("os.name").contains("Windows")) {
                pathCucumber = PATHEVIDENCEWIN ;
            }

            if(System.getProperty("os.name").contains("Linux")){
                pathCucumber = PATHEVIDENCELINUX;
            }


            File folder = new File(pathCucumber);
            if (!folder.exists()) {
                if (folder.mkdirs()) {
                    path = pathCucumber;
                    id = 1;
                } else {
                    System.out.println("Falha ao criar diretório!");
                }
            }
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(pathCucumber + id + ".jpg");
            String imageDest = pathCucumber + id + ".jpg";
            FileUtils.copyFile(scrFile, dest);
            Reporter.addScreenCaptureFromPath(imageDest);

        }


    }



}
