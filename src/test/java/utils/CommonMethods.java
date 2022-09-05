package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.chrome.ChromeOptions;
import tests.PageInitializer;



public class CommonMethods extends PageInitializer {

    public static WebDriver driver;
    @BeforeEach
        public void openBrowser(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(false); //for unix based set true
            driver = new ChromeDriver(options);
            driver.get(Constants.baseURL);
            driver.manage().window().maximize();
            initializePageObjects();
        }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    public static JavascriptExecutor getJSExecutor(){
        return (JavascriptExecutor) driver;
    }
    public static void click(WebElement element){
            element.click();
    }
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

}
