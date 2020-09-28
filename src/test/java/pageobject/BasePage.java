package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private int timeout = 0;
    private final static String URL = "http://localhost:7080";

    public BasePage(WebDriver driver, String path) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(URL + path);

    }

    protected void setTimeout(int timeout) {
        this.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    protected void accessUrl(String path) {
        this.driver.get(URL + path);
    }


}
