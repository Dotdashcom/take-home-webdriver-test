package theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver;
    public String browser;
    public String baseUrl;
    public Properties properties;
    public void loadProperties(){
        FileInputStream config = null;

        try{
            properties = new Properties();
            config = new FileInputStream("src/main/java/theinternet/config/config.properties");
            properties.load(config);

            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try {
                config.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void openBrowser(){
        if(browser.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void closeBrowser(){
        driver.quit();
    }
}
