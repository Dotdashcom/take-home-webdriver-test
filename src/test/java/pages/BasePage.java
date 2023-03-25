package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        this.driver=driver;
    }

    public WebElement getElement(By elementSelector){
        return driver.findElement(elementSelector);
    }

    public String getMessage(By message){
        return getElement(message).getText();
    }

    public void goToUrl(String baseUrl, String url){
        driver.get(baseUrl+"/"+url);
    }

}
