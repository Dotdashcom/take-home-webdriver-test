package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
     public static Properties prop;

     public BaseClass() {
         prop = new Properties();
         try {
          // FileInputStream ip = new FileInputStream("//Users//saimadhavi//GitHubAssign//src//main//java//Config.properties");
           FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Config.properties");

             prop.load(ip);
         } catch (FileNotFoundException e) {
             e.printStackTrace();

         } catch (IOException e) {
             e.printStackTrace();
         }

     }
    public static void initialization(){
         String browser = prop.getProperty("Browser");
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();


    }

}
