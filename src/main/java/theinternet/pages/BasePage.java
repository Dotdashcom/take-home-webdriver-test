package theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    public static Properties properties;
    public void loadConfig(){
        FileInputStream config = null;
        try{
            properties = new Properties();
            config = new FileInputStream("src/main/java/theinternet/config/config.properties");
            properties.load(config);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void launchBrowser(){
        this.loadConfig();
        String browser = properties.getProperty("browser");

        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(properties.getProperty("baseUrl"));
    }

    public static void quitBrowser(){
        driver.quit();
        driver = null;
    }
}
