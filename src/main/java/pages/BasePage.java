package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public <T> T getPageObject(String pageName, Class<T> pageClassToProxy){
        String landingURL = ConfigReader.getApplicationProperty("baseURL");
        String fullPageURL = landingURL + pageName;
        driver.get(fullPageURL);
        pauseInSeconds(1);

        return PageFactory.initElements(driver, pageClassToProxy);
    }

    public void pauseInSeconds(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exceptions occurred.");
        }
    }
}
