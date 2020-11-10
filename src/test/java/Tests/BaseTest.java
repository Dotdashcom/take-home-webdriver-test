package Tests;

import Utils.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public int browser_timeout = 15; //seconds
    public String browser, base_url, password;

    public WebDriver getDriver() {
        return driver;
    }

    //Read Password From the Config File
    public String getPassword() throws IOException{
        Utils utils = new Utils();
        password = utils.read_from_config_file("config", "password");
        return password;
    }

    @BeforeClass
    @Step("Set up Browser and BaseURL from Config File")
    public void set_up() throws IOException
    {
        //Extract browser and base_url from the Config file under Configs Folder
        Utils utils = new Utils();
        browser = utils.read_from_config_file("config", "browser");
        base_url = utils.read_from_config_file("config", "base_url");

        if (browser.equalsIgnoreCase("chrome")) {
            //Set preference downloading any file in the Download Folder under the Project for Chrome
//          //https://stackoverflow.com/questions/34515328/how-to-set-default-download-directory-in-selenium-chrome-capabilities
            String download_folder = "Downloads";
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + download_folder);
            System.setProperty("weaveJavaxPackages","true");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            //Set property for Chrome driver
            String driver_path = utils.read_from_config_file("config", "chrome_driver_path");
            System.setProperty("webdriver.chrome.driver", driver_path);
            //Initiating the driver
            driver = new ChromeDriver(options);
        }
        //Maximize Window
        driver.manage().window().maximize();
        //Set timeout for Implicit Wait
        driver.manage().timeouts().implicitlyWait(browser_timeout, TimeUnit.SECONDS);
    }

    @AfterClass
    @Step("Close WebDriver")
    public void tear_down() { driver.quit();}

    @AfterSuite
    @Step("Create Allure Environment Variable Information")
    public void create_env_allure_result()
    {
        Utils utils = new Utils();
        //Setting up Test Environmental Info in the Allure Report
        utils.create_allure_xml_file(browser,base_url);
    }

}