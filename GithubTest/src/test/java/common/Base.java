package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
*  I am using the base class where I am initializing the web browser and doing implicit wait
*  and maximizing the window for code reusability so that I will not have to initialize the web browser
*  and do other stuff again and again. I can just inherit this class in my other class.
*  Which is also a concept of Inheritance in OOP.
* */

public class Base {
    public static WebDriver driver;
    public static String baseURI;

    @Test
    public static  WebDriver getDriver() {


        // Initializing the webdriver using the webdrivermanager dependency
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        baseURI = "http://localhost:7080";

        // To maximize a window
        driver.manage().window().maximize();

       /* what is syncronizaton - sometimes our code/automation script run faster than the code then the issue comes,
          in order to overcome the issue we have to ues implicit wait which is a dynamic wait.
          It is a global wait for all the element in the web page. Lets say some cases the page is fully
          loaded, however some of the element which is not and I want that specific element in this case it will
          throw no element found exception.
          Once the page is fully loaded we are telling selenium please wait next 30 sec to perform the action in specific
          element. But its not compulsory to wait until 30 sec. Lets say if the element found in 30 sec the rest
          28 second will be ignored.
          */

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;

    }
}
