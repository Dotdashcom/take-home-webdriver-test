package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage extends Base {
    WebDriver driver;

    By startButton = By.xpath(readValue("dynamicLoading.startButtonXp"));
    By helloHeader = By.xpath(readValue("dynamicLoading.helloHeaderXp"));

    public void clickStartButton() {
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(helloHeader));
    }

    public String getTextHelloHeader() {
        return driver.findElement(helloHeader).getText();
    }

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }
}
