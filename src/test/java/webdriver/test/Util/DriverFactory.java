package webdriver.test.Util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    // we  can simply handle driver download programmatically based on os version using Webdriver Manager
    // add maven dependency and use

    //  <dependency>
    //    <groupId>io.github.bonigarcia</groupId>
    //    <artifactId>webdrivermanager</artifactId>
    //    <version>3.0.0</version>
    //    <scope>test</scope>
    //  </dependency>

    //          add below commond also
    //        WebDriverManager.chromedriver().setup();
    //        WebDriver driver = new ChromeDriver();

    //OR

    //Your driver version has to be changed according the OS version
    public static WebDriver getDriver(String driverType) {
        WebDriver driver = null;
        String pathOfDrivers = "";
        String OS = System.getProperty("os.name");
        boolean headlesschrome = false;
        String driverName;

        if (OS.toLowerCase().contains("mac")) {

            OS = "mac";

            pathOfDrivers = System.getProperty("user.dir") + "/src/test/resource/WebDrivers/";


        } else if (OS.toLowerCase().contains("win")) {

            OS = "win";

            pathOfDrivers = System.getProperty("user.dir") + "//src//test//resource//WebDrivers//";


        } else if (OS.toLowerCase().contains("linux")) {

            OS = "linux";

            headlesschrome = true;

            // You can download linux chromedriver version and put it in resource folder and change path here
            //The server expects you to have Chrome installed in the default location
            pathOfDrivers = System.getProperty("user.dir") + "/usr/bin/google-chrome";


        }


        if (driverType != null) {

            if (driverType.equals("chrome")) {

                if (OS.equals("mac") || OS.equals("linux")) {

                    driverName = "chromedriver";

                } else driverName = "chromedriverWin.exe";

                System.setProperty("webdriver.chrome.driver", pathOfDrivers + driverName);

                if (headlesschrome) {

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);

                } else driver = new ChromeDriver();


            } else if (driverType.equals("firefox")) {

                if (OS.equals("mac") || OS.equals("linux")) {

                    driverName = "geckodriver";

                } else driverName = "geckodriverWin.exe";

                System.setProperty("webdriver.gecko.driver", pathOfDrivers + driverName);

                driver = new FirefoxDriver();
            }
        }

        return driver;



    }
}
