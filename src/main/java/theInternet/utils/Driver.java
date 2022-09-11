package theInternet.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){

        /*if there is already a driver created,
        this won't create a new driver, and will return the one already created*/
//        if(driver==null){
//            WebDriverManager.chromedriver().setup();
//            driver=new ChromeDriver();
//        }
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();


        return driver;
    }
}
