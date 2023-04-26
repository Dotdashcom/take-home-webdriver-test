package resources.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

    public static WebDriver driver;
    public Properties prop;

    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(".src/test/java/resources/config.properties");
            prop.load(fis);
        }catch(IOException e){

        }
    }

    public WebDriver getDriver(){

        if(driver!=null){
            return driver;
        }

        if(driver==null || ((RemoteWebDriver)driver).getSessionId()==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void setupDownload(String urlPath) {
        String location = System.getProperty("user.dir")+"\\Downloads";
        HashMap preferences= new HashMap();
        preferences.put("download.default_directory",location);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);

        String burl=prop.getProperty("baseUrl");
        getDriver().get(burl+urlPath);
    }

    @And("User closes the browser")
    public void tearDown() {
        driver.quit();
    }
}
