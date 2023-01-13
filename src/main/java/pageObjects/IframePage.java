package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframePage extends Base {
    WebDriver driver;

    By iframe = By.xpath(readValue("iframePage.iframeXp"));
    By inputBox = By.xpath(readValue("iframePage.inputBoxFieldXp"));

    public void sendText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement frame = driver.findElement(iframe);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        WebElement box = driver.findElement(inputBox);
        wait.until(ExpectedConditions.textToBe(inputBox, "Your content goes here."));
        box.clear();
        box.sendKeys(text);
    }

    public String getTextBox() {
        return driver.findElement(inputBox).getText();
    }

    public IframePage(WebDriver driver) {
        this.driver = driver;
    }
}
